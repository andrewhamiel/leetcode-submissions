class Solution {
    public boolean isValidPalindrome(String s, int k) {
        return longestPalindromicSubstring(s) + k >= s.length();
    }

    private int longestPalindromicSubstring(String s){
        return longestCommonSubsequence(s.toCharArray(), new StringBuilder(s).reverse().toString().toCharArray());
    }

    private int longestCommonSubsequence(char[] arr1, char[] arr2){
        int[][] memo = new int[arr1.length + 1][arr2.length + 1];
        for(int i = arr1.length - 1; i >= 0; i--){
            for(int j = arr2.length - 1; j >= 0; j--){
                if(arr1[i] == arr2[j]) memo[i][j] = 1 + memo[i + 1][j + 1];
                else memo[i][j] = Math.max(memo[i + 1][j], memo[i][j + 1]);
            }
        }
        return memo[0][0];
    }
}