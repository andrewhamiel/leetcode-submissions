class Solution {
    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    }
    
    private int longestCommonSubsequence(String text1, String text2){
        if(text2.length() < text1.length()) return longestCommonSubsequence(text2, text1);
        int[] previous = new int[text1.length() + 1];
        for(int col = text2.length() - 1; col >= 0; col--){
            int[] current = new int[text1.length() + 1];
            for(int row = text1.length() - 1; row >= 0; row--){
                if(text2.charAt(col) == text1.charAt(row)) current[row] = 1 + previous[row+1];
                else current[row] = Math.max(current[row+1], previous[row]);
            }
            previous = current;
        }
        return previous[0];
    }
}