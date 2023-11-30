class Solution {
    String s;
    List<String> wordDict;
    int[] memo;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        memo = new int[s.length()];
        return dp(s.length() - 1);    
    }

    private boolean dp(int ind){
        if(ind < 0) return true;
        
        if(memo[ind] != 0) return memo[ind] == 1;

        for(String word : wordDict){
            if(ind - word.length() + 1 < 0) continue;

            if(s.substring(ind - word.length() + 1, ind + 1).equals(word) && dp(ind - word.length())){
                memo[ind] = 1;
                return true;
            }
        }
        memo[ind] = -1;
        return false;
    }
}