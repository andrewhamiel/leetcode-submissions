class Solution {
    private int[][] memo;
    String t1, t2;
    
    public int longestCommonSubsequence(String text1, String text2) {
        t1 = text1;
        t2 = text2;
        memo = new int[t1.length()][t2.length()];
        for(int[] row : memo) Arrays.fill(row, -1);
        
        return dp(0, 0);
    }
    
    private int dp(int p1, int p2){
        if(p1 >= t1.length() || p2 >= t2.length()) return 0;
        if(memo[p1][p2] != -1) return memo[p1][p2];
        
        if(t1.charAt(p1) != t2.charAt(p2)) memo[p1][p2] = Math.max(dp(p1+1, p2), dp(p1, p2+1));
        else memo[p1][p2] = 1 + dp(p1+1, p2+1);
        
        return memo[p1][p2];
    }
}