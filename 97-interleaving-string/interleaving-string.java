 public class Solution {
     private int[][] memo;
     String s1, s2, s3;
     
     public boolean isInterleave(String s1, String s2, String s3) {
         if(s1.length() + s2.length() != s3.length()) return false;
         memo = new int[s1.length()][s2.length()];
         this.s1 = s1;
         this.s2 = s2;
         this.s3 = s3;
         for(int i = 0; i < memo.length; i++){
             for(int j = 0; j < memo[0].length; j++) memo[i][j] = -1;
         }
         return is_interleave(0, 0, 0);
    }
     
    public boolean is_interleave(int i, int j, int k) {
        if(i == s1.length()) return s2.substring(j).equals(s3.substring(k));
        if(j == s2.length()) return s1.substring(i).equals(s3.substring(k));
        
        //if memoized
        if(memo[i][j] >= 0) return memo[i][j] == 1;
        
        boolean ans = false;
        if((s3.charAt(k) == s1.charAt(i) && is_interleave(i+1, j, k+1))
            || (s3.charAt(k) == s2.charAt(j) && is_interleave(i, j+1, k+1))) ans = true;
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
    
}