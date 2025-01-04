class Solution {
    /*
    * KMP. LPS aka longest border finds longest prefix that is also suffix. Allows us to reuse prefixes
    */
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;

        //1. Preprocessing
        int[] longestBorder = new int[needle.length()];
        int prevLongest = 0, ind = 1; //longestBorder[0] always 0 because str cannot be prefix/suffix of self
        while(ind < needle.length()) {
            //Increment prevLongest
            if(needle.charAt(ind) == needle.charAt(prevLongest)) {
                prevLongest++;
                longestBorder[ind++] = prevLongest;
            }else {
                if(prevLongest == 0) longestBorder[ind++] = 0; //No characters match
                else prevLongest = longestBorder[prevLongest - 1]; //Look for smaller calculated prefix match
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
                else needleInd = longestBorder[needleInd - 1]; //Look for smaller prefix match
            }
        }
        return -1;
    }
}