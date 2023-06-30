class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return b[1] - a[1];
                else return a[0] - b[0];
            }
        });

        int[] dp = new int[envelopes.length];
        for(int i = 0; i < dp.length; i++) dp[i] = envelopes[i][1];
        return longestIncreasingSubsequence(dp);
    }

    private int longestIncreasingSubsequence(int[] nums){
        List<Integer> subArr = new ArrayList<>();
        subArr.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > subArr.get(subArr.size() - 1)) subArr.add(nums[i]);
            else subArr.set(binarySearch(subArr, nums[i]), nums[i]);            
        }
        return subArr.size();
    }

    private int binarySearch(List<Integer> nums, int target){
        int left = 0, right = nums.size() - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}