class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;

        //1. Preprocessing
        int[] longestBorder = new int[needle.length()];
        int longestPrev = 0, ind = 1; //longestBorder[0] always 0 because string cannot be prefix/suffix of itself
        while(ind < needle.length()) {
            //Increment longest prev
            if(needle.charAt(ind) == needle.charAt(longestPrev)) {
                longestPrev++;
                longestBorder[ind++] = longestPrev;
            }else {
                if(longestPrev == 0) longestBorder[ind++] = 0;
                else longestPrev = longestBorder[longestPrev - 1];
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