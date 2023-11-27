class Solution {
    private String s;
    private List<String> wordDict;
    private int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s.length() - 1);
    }

    private boolean dp(int ind){
        if(ind < 0) return true;

        if(memo[ind] != -1) return memo[ind] == 1;

        for(String word : wordDict){
            if(ind - word.length() + 1 < 0) continue;

            if(s.substring(ind - word.length() + 1, ind + 1).equals(word) && dp(ind - word.length())){
                memo[ind] = 1;
                return true;
            }
        }
        memo[ind] = 0;
        return false;
    }
}