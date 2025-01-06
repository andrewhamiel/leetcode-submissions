class Solution {
    /* KMP. LPS aka Longest Border keeps track of longest substring that is both prefix and suffix. This allows us to reuse prefixes. */
    public int strStr(String haystack, String needle) {
        //1. Preprocessing
        int[] longestBorder = new int[needle.length()];
        int longestPrev = 0, ind = 1; //longestBorder[0] is always 0 -> cannot be prefix of itself
        while(ind < needle.length()) {
            //Expand longest prev
            if(needle.charAt(ind) == needle.charAt(longestPrev)) {
                longestPrev++;
                longestBorder[ind++] = longestPrev;
            }else {
                if(longestPrev == 0) longestBorder[ind++] = 0; //No characters match
                else longestPrev = longestBorder[longestPrev - 1]; //Look for longest border of shorter prefix
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