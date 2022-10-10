class Solution {
    int[][] dp;
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[nums1.length + 1][nums2.length + 1];
        for(int i = nums1.length-1; i >= 0; i--){
            for(int j = nums2.length - 1; j >= 0; j--){
                int max = Math.max(dp[i+1][j], dp[i][j+1]);
                if(nums1[i] == nums2[j]) max = Math.max(max, 1 + dp[i+1][j+1]);
                dp[i][j] = max;
            }
        }
        return dp[0][0];
    }
}