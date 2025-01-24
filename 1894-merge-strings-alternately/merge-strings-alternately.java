class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int word1Ind = 0, word2Ind = 0;
        while(word1Ind < word1.length() && word2Ind < word2.length()) {
            result.append(word1.charAt(word1Ind++));
            result.append(word2.charAt(word2Ind++));
        }

        while(word1Ind < word1.length()) result.append(word1.charAt(word1Ind++));
        while(word2Ind < word2.length()) result.append(word2.charAt(word2Ind++));

        return result.toString();
    }
}