class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1Ind = 0, word2Ind = 0, ind = 0;
        StringBuilder sb = new StringBuilder();
        while(word1Ind < word1.length() && word2Ind < word2.length()){
            if(ind % 2 == 0) sb.append(word1.charAt(word1Ind++));
            else sb.append(word2.charAt(word2Ind++));
            ind++;
        }

        while(word1Ind < word1.length()) sb.append(word1.charAt(word1Ind++));
        while(word2Ind < word2.length()) sb.append(word2.charAt(word2Ind++));
        return sb.toString();
    }
}