class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int currNumber = 0;
        int wordPtr = 0;
        for(Character c : abbr.toCharArray()){
            if(wordPtr >= word.length()) return false;
            if(Character.isDigit(c)){
                if((int)(c - '0') == 0 && currNumber == 0) return false;
                currNumber*=10;
                currNumber+= (int)(c - '0');
            }else if(currNumber != 0){
                wordPtr+= currNumber;
                currNumber = 0;
                if(wordPtr >= word.length() || word.charAt(wordPtr++) != c) return false;
            }else{
                if(word.charAt(wordPtr++) != c) return false;
            }
        }
        if(currNumber != 0) wordPtr += currNumber;
        return wordPtr == word.length();
    }
}