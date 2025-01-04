class Solution {
    /*
    * KMP
    * LPS aka Longest Border is longest prefix that is also a suffix to reuse prefixes
    */
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;

        //1. Preprocess
        int[] longestBorder = new int[needle.length()];
        int prevLongest = 0, ind = 1; //longestBorder[0] always 0
        while(ind < needle.length()) {
            //Expand prev longest border
            if(needle.charAt(ind) == needle.charAt(prevLongest)){
                prevLongest++;
                longestBorder[ind++] = prevLongest;
            } else {
                if(prevLongest == 0) longestBorder[ind++] = 0; //No matching chars
                else prevLongest = longestBorder[prevLongest - 1]; //See if smaller previous match
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