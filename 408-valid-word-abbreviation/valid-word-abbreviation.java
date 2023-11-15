class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPtr = 0, abbrPtr = 0, digits = 0;
        while(wordPtr < word.length() && abbrPtr < abbr.length()){
            char c = abbr.charAt(abbrPtr);
            if(Character.isDigit(c)){
                if(digits == 0 && c == '0') return false;
                digits*= 10;
                digits+= (int)(c - '0');
                abbrPtr++;
            }else if(digits != 0){
                    wordPtr+= digits;
                    digits = 0;
            }else{
                if(word.charAt(wordPtr) != c) return false;
                wordPtr++;
                abbrPtr++;
            }
        }
        if(digits != 0) wordPtr+= digits;
        return wordPtr == word.length() && abbrPtr == abbr.length();
    }
}