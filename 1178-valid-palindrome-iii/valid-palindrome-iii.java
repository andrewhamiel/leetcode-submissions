class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString()) + k >= s.length();
    }

    private int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = s1.length() - 1; i >= 0; i--) {
            for(int j = s2.length() - 1; j >= 0; j--) {
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = 1 + dp[i + 1][j + 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}