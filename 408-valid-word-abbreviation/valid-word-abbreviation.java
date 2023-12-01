class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordInd = 0, abbrInd = 0, currNum = 0;
        while(abbrInd < abbr.length() && wordInd < word.length()){
            if(Character.isDigit(abbr.charAt(abbrInd))){
                if(currNum == 0 && abbr.charAt(abbrInd) == '0') return false;
                currNum*= 10;
                currNum+= (int)(abbr.charAt(abbrInd++) - '0');
            }else if(currNum > 0){
                    wordInd+= currNum;
                    currNum = 0;
            }else if(word.charAt(wordInd++) != abbr.charAt(abbrInd++)) return false;
        }
        if(currNum != 0) wordInd+= currNum;
        return wordInd == word.length() && abbrInd == abbr.length();
    }
}