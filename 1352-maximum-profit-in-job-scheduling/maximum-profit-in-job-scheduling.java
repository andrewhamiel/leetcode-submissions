class Solution {
    private int[] memo = new int[50001];

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //fill memo
        Arrays.fill(memo, -1);
        //Fill Jobs list
        List<List<Integer>> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++){
            List<Integer> job = new ArrayList<>();
            job.add(startTime[i]);
            job.add(endTime[i]);
            job.add(profit[i]);
            jobs.add(job);
        }
        //Sort by startTime 
        jobs.sort(Comparator.comparingInt(a -> a.get(0)));
        //Find max profit
        for(int i = 0; i < jobs.size(); i++){
            startTime[i] = jobs.get(i).get(0);
        }
        return findMaxProfit(jobs, 0);
    }

    private int findMaxProfit(List<List<Integer>> jobs, int position){
        if(position == jobs.size()) return 0;

        if(memo[position] != -1) return memo[position];

        int nextIndex = findNextIndex(jobs, jobs.get(position).get(1));

        //skip or schedule
        int maxProfit = Math.max(findMaxProfit(jobs, position + 1),
        jobs.get(position).get(2) + findMaxProfit(jobs, nextIndex));
        
        return memo[position] = maxProfit;
    }

    private int findNextIndex(List<List<Integer>> jobs, int lastEndIndex){
        int left = 0, right = jobs.size() - 1, nextIndex = jobs.size();
        while(left <= right){
            int mid = left + (right - left)/2;
            if(jobs.get(mid).get(0) >= lastEndIndex){
                nextIndex = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return nextIndex;
    }
}