class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return longestPalindromicSubstring(s) + k >= s.length();        
    }

    private int longestPalindromicSubstring(String s){
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    }

    private int longestCommonSubsequence(String word1, String word2){
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for(int i = word1.length() - 1; i >= 0; i--){
            for(int j = word2.length() - 1; j >= 0; j--){
                if(word1.charAt(i) == word2.charAt(j)) memo[i][j] = 1 + memo[i + 1][j + 1];
                else memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
            }
        }
        return memo[0][0];
    }
}