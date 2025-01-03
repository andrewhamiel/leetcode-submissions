class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        //1. Preprocessing
        int[] longestBorder = new int[needle.length()];
        int prevLongest = 0, ind = 1; //longestBorder[0] always 0, prefix/suffix can not be the string
        while(ind < needle.length()) {
            //Increment longest length
            if(needle.charAt(ind) == needle.charAt(prevLongest)) {
                prevLongest++;
                longestBorder[ind++] = prevLongest;
            }else {
                if(prevLongest == 0) longestBorder[ind++] = 0; //Only empty borders seen
                else prevLongest = longestBorder[prevLongest - 1]; //Try finding longest border for this ind with reduced prev
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
                if(needleInd == 0) haystackInd++; //No chars matched
                else needleInd = longestBorder[needleInd - 1]; //Optimally shift left. Leave haystackInd unchanged
            }
        }
        return -1;
    }
}