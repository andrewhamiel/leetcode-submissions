class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordInd = 0;
        for(int i = 0; i < abbr.length(); i++){
            //Case 1: Character is numeric
            if(Character.isDigit(abbr.charAt(i))){
                int subLength = 0;
                //Until the number has been evaluated completely
                while(i < abbr.length() && Character.isDigit(abbr.charAt(i))){
                    if(subLength == 0 && (int)(abbr.charAt(i) - '0') == 0) return false;
                    subLength*=10;
                    subLength += (int)(abbr.charAt(i++) - '0');
                }
                i--;
                if(wordInd + subLength - 1 < word.length()) wordInd+= subLength;
                else return false; //If end of string, false
            }
            //Case 2: Literal Character
            else if(wordInd < word.length() && word.charAt(wordInd) == abbr.charAt(i)) wordInd++;
            //Case 3: Character mismatch, return false
            else return false;
        }
        return wordInd == word.length();
    }
}