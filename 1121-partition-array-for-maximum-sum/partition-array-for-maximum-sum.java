class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return dp(arr, k, dp, 0);
    }

    private int dp(int[] arr, int k, int[] dp, int start){
        int N = arr.length;

        if(start >= N) return 0;

        if(dp[start] != -1) return dp[start];

        int end = Math.min(N, start + k), currMax = arr[start], ans = 0;
        for(int i = start; i < end; i++){
            currMax = Math.max(currMax, arr[i]);
            ans = Math.max(ans, currMax * (i - start + 1) + dp(arr, k, dp, i + 1));
        }
        return dp[start] = ans;
    }
}