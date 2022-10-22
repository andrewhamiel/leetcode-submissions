class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int j = 1; j < pairs.length; j++) {
            int curr = 1;
            for (int i = 0; i < j; i++) {
                if (pairs[i][1] < pairs[j][0]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    curr = Math.max(curr, dp[j]);
                }
            }
            ans = Math.max(ans, curr);
        }

        return ans;
    }
}