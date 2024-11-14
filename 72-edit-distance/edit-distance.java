class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for(int word1Index = 1; word1Index <= word1.length(); word1Index++) dp[word1Index][0] = word1Index;

        for(int word2Index = 1; word2Index <= word2.length(); word2Index++) dp[0][word2Index] = word2Index;

        for(int word1Ind = 1; word1Ind < dp.length; word1Ind++) {
            for(int word2Ind = 1; word2Ind < dp[0].length; word2Ind++) {
                if(word1.charAt(word1Ind - 1) == word2.charAt(word2Ind - 1)) dp[word1Ind][word2Ind] = dp[word1Ind - 1][word2Ind - 1];
                else {
                    //3 options: insert, replace, delete
                    int replace = dp[word1Ind - 1][word2Ind - 1];
                    int insert = dp[word1Ind][word2Ind - 1];                   
                    int delete = dp[word1Ind - 1][word2Ind];
                    dp[word1Ind][word2Ind] = Math.min(insert, Math.min(replace, delete)) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}