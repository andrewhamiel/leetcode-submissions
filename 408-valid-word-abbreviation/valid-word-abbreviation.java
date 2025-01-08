class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordInd = 0, abbrInd = 0, currDigit = 0;
        while(abbrInd < abbr.length()) {
            char c = abbr.charAt(abbrInd++);
            if(Character.isDigit(c)) {
                if(currDigit == 0 && c == '0') return false; //Leading zeroes
                currDigit*= 10;
                currDigit+= c - '0';
            }else {
                wordInd+= currDigit;
                currDigit = 0;
                if(wordInd >= word.length() || word.charAt(wordInd++) != c) return false;
            }
        }
        wordInd+= currDigit;
        return wordInd == word.length();
    }
}