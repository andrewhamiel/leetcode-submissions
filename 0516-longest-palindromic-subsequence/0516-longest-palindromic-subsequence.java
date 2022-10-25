class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int subseqLen = 0; subseqLen < s.length(); subseqLen++){
            for(int i = 0, j = subseqLen; j < s.length(); i++, j++){
                if(subseqLen == 0) dp[i][j] = 1;
                else if(subseqLen == 1){
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2;
                    else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }else{
                    if(s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + dp[i+1][j-1];
                    else dp[i][j] = Math.max(dp[i][j], Math.max(dp[i+1][j], dp[i][j-1]));
                }
            }
        }
        return dp[0][s.length() - 1];
        
    }
}