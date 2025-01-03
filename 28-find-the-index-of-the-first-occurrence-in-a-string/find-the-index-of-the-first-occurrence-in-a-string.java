class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        //1. Preprocessing
        int[] longestBorder = new int[needle.length()];
        int prevLongest = 0, ind = 1;
        while(ind < needle.length()) {
            //Increase longest length
            if(needle.charAt(ind) == needle.charAt(prevLongest)) {
                prevLongest++;
                longestBorder[ind++] = prevLongest;
            }else {
                //Only empty border exist?
                if(prevLongest == 0) longestBorder[ind++] = 0;
                else prevLongest = longestBorder[prevLongest - 1]; //Try finding longest border for this ind with reduced prev?               
            }
        }

        //2. Searching
        int haystackPtr = 0, needlePtr = 0;
        while(haystackPtr < haystack.length()) {
            if(haystack.charAt(haystackPtr) == needle.charAt(needlePtr)) {
                haystackPtr++;
                needlePtr++;
                //All characters matched
                if(needlePtr == needle.length()) return haystackPtr - needle.length(); //m characters behind last matching will be start of window?
            }else {
                if(needlePtr == 0) haystackPtr++; //No chars matched
                else needlePtr = longestBorder[needlePtr - 1]; //Optimally shift needlePtr left. Don't change haystack ptr?
            }
        }
        return -1;
    }
}