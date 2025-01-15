class Solution {
    public int strStr(String haystack, String needle) {
        int[] longestBorder = new int[needle.length()];
        //1. Preprocess
        int longestPrev = 0, ind = 1; //LongestBorder[0] = 0 because cannot be suffix of itself
        while(ind < needle.length()) {
            if(needle.charAt(ind) == needle.charAt(longestPrev)) {
                longestPrev++;
                longestBorder[ind++] = longestPrev;
            }else {
                if(longestPrev == 0) longestBorder[ind++] = 0; //No characters match
                else longestPrev = longestBorder[longestPrev - 1];
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
                if(needleInd == 0) haystackInd++; //No characters match
                else needleInd = longestBorder[needleInd - 1];
            }
        }
        return -1;
    }
}