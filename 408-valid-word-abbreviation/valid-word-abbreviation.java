class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordInd = 0, abbrInd = 0, currNum = 0;
        while(abbrInd < abbr.length()) {
            char c = abbr.charAt(abbrInd);
            if(Character.isDigit(c)) {
                if(abbr.charAt(abbrInd++) == '0' && currNum == 0) return false;
                currNum*= 10;
                currNum+= c - '0';
            }else {
                wordInd+= currNum;
                currNum = 0;
                if(wordInd >= word.length() || word.charAt(wordInd++) != abbr.charAt(abbrInd++)) return false;
            }
        }
        wordInd+= currNum;
        return wordInd == word.length();
    }
}