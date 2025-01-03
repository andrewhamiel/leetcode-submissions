class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        //1. Preprocessing
        int[] longestBorder = new int[needle.length()];
        int longestPrev = 0, ind = 1; //longestBorder[0] always 0, prefix/suffix cannot be string itself
        while(ind < needle.length()) {
            //Increase longest length
            if(needle.charAt(ind) == needle.charAt(longestPrev)) {
                longestPrev++;
                longestBorder[ind++] = longestPrev;
            }else {
                if(longestPrev == 0) longestBorder[ind++] = 0; //Only empty borders exist
                else longestPrev = longestBorder[longestPrev - 1]; //Try finding longest border for this ind with reduced prev
            }
        }

        //2. Searching
        int haystackInd = 0, needleInd = 0;
        while(haystackInd < haystack.length()) {
            if(haystack.charAt(haystackInd) == needle.charAt(needleInd)) {
                haystackInd++;
                needleInd++;
                //All characters matched
                if(needleInd == needle.length()) return haystackInd - needle.length();
            }else {
                if(needleInd == 0) haystackInd++; //No characters matched
                else needleInd = longestBorder[needleInd - 1];
            }
        }
        return -1;
    }
}