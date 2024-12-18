class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> mins = new ArrayList<>();
        for(String time : timePoints) {
            String[] split = time.split(":");
            mins.add(calculateMins(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        Collections.sort(mins);
        int minTime = Integer.MAX_VALUE;
        for(int i = 1; i < mins.size(); i++) {
            minTime = Math.min(minTime, mins.get(i) - mins.get(i - 1));
        }
        
        //calculate distance from first/last 
        int minsFromMidnight = calculateMins(24, 0) - mins.get(mins.size() - 1);
        minTime = Math.min(minTime, minsFromMidnight + mins.get(0));
        return minTime;
    }

    private int calculateMins(int hours, int mins) {
        return 60 * hours + mins;
    }
}