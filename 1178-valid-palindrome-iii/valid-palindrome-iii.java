class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString()) + k >= s.length();
    }

    private int longestCommonSubsequence(String num1, String num2) {
        int[][] dp = new int[num1.length() + 1][num2.length() + 1];

        for(int row = num1.length() - 1; row >= 0; row--) {
            for(int col = num2.length() - 1; col >= 0; col--) {
                if(num1.charAt(row) == num2.charAt(col)) dp[row][col] = 1 + dp[row + 1][col + 1];
                else dp[row][col] = Math.max(dp[row][col + 1], dp[row + 1][col]);
            }
        }
        return dp[0][0];
    }
}