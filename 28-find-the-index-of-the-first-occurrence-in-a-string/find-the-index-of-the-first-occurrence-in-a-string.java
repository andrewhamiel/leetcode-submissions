class Solution {
    public int strStr(String haystack, String needle) {
        //Key intuition: longest border, KMP
        int[] longestBorder = new int[needle.length()];
        //1. Preprocess
        int longestPrev = 0, ind = 1; //longestBorder[0] always 0, cannot be prefix of self
        while(ind < needle.length()) {
            //Expand longest prev
            if(needle.charAt(longestPrev) == needle.charAt(ind)) {
                longestPrev++;
                longestBorder[ind++] = longestPrev;
            }else {
                if(longestPrev == 0) longestBorder[ind++] = 0; //No characters match
                else longestPrev = longestBorder[longestPrev - 1]; //Rollback to previous prefix
            }
        }

        //2. Search
        int haystackInd = 0, needleInd = 0;
        while(haystackInd < haystack.length()) {
            if(haystack.charAt(haystackInd) == needle.charAt(needleInd)) {
                haystackInd++;
                needleInd++;
                //All characters match
                if(needleInd == needle.length()) return haystackInd - needle.length();
            }else {
                if(needleInd == 0) haystackInd++; //No chars match
                else needleInd = longestBorder[needleInd - 1]; //Find prev prefix as starting point
            }
        }
        return -1;
    }
}