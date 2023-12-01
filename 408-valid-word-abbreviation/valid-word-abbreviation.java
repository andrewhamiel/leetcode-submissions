class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPtr = 0, abbrPtr = 0, currNum = 0;
        while(wordPtr < word.length () && abbrPtr < abbr.length()){
            if(Character.isDigit(abbr.charAt(abbrPtr))){
                if(currNum == 0 && abbr.charAt(abbrPtr) == '0') return false;
                currNum*= 10;
                currNum+= (int)(abbr.charAt(abbrPtr++) - '0');
            }else if(currNum > 0){
                wordPtr+= currNum;
                currNum = 0;
            }else if(word.charAt(wordPtr++) != abbr.charAt(abbrPtr++)) return false;
        }

        if(currNum != 0) wordPtr+= currNum;
        return wordPtr == word.length() && abbrPtr == abbr.length();
    }
}