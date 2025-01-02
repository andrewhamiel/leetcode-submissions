class Solution {
    public int strStr(String haystack, String needle) {
        int haystackPtr = 0;
        while(haystackPtr < haystack.length()) {
            if(haystack.charAt(haystackPtr) == needle.charAt(0)) {
                boolean isFound = true;
                for(int i = 0; i < needle.length(); i++) {
                    if(haystackPtr + i >= haystack.length()) return -1;
                    if(haystack.charAt(haystackPtr + i) != needle.charAt(i)) {
                        isFound = false;
                        break;
                    }
                }
                if(isFound) return haystackPtr;
            }
            haystackPtr++;
        }
        return -1;
    }
}