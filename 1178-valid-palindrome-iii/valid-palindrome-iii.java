class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString()) + k >= s.length();
    }

    private int longestCommonSubsequence(String num1, String num2) {
        int[] prev = new int[num1.length() + 1];
        for(int row = num1.length() - 1; row >= 0; row--) {
            int[] curr = new int[num1.length() + 1];
            for(int col = num2.length() - 1; col >= 0; col--) {
                if(num1.charAt(row) == num2.charAt(col)) curr[col] = 1 + prev[col + 1];
                else curr[col] = Math.max(curr[col + 1], prev[col]);
            }
            prev = curr;
        }
        return prev[0];
    }
}