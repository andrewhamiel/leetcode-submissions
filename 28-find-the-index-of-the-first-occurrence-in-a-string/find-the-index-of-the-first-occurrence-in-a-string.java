class Solution {
    public int strStr(String haystack, String needle) {
        int[] longestBorder = new int[needle.length()];
        int prevLongest = 0, ind = 1; //LongestBorder[0] always 0, cannot be prefix of self
        //1. Processing
        while(ind < needle.length()) {
            if(needle.charAt(ind) == needle.charAt(prevLongest)) {
                //Expand border
                prevLongest++;
                longestBorder[ind++] = prevLongest;
            }else {
                if(prevLongest == 0) longestBorder[ind++] = 0; //No matches
                else prevLongest = longestBorder[prevLongest - 1]; //Next smallest border
            }
        }

        //2. Searching
        int haystackInd = 0, needleInd = 0;
        while(haystackInd < haystack.length()) {
            if(haystack.charAt(haystackInd) == needle.charAt(needleInd)) {
                haystackInd++;
                needleInd++;
                //All characters match
                if(needleInd == needle.length()) return haystackInd - needle.length();
            }else {
                if(needleInd == 0) haystackInd++; //No characters match
                else needleInd = longestBorder[needleInd - 1];
            }
        }
        return -1;
    }
}