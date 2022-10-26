class Solution {
    //naive O(n^2)
    public int longestRepeatingSubstring(String s) {
        // char[] str = s.toCharArray();
        int max=0;
        // int len = str.length;
        int[][] dp = new int[s.length()+1][s.length()+1];
        
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                    max = Math.max(dp[i+1][j+1],max);
                }
            }
        }
        return max;
    }
}