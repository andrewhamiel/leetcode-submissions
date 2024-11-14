class Solution {
    public String longestPalindrome(String s) {
        int longestSubstring = 0, leftInd = 0, rightInd = 0;
        for(int i = 0; i < s.length(); i++) {
            int oddLength = middleOut(i, i, s);
            int evenLength = middleOut(i, i + 1, s);
            if(oddLength > longestSubstring || evenLength > longestSubstring) {
                longestSubstring = Math.max(oddLength, evenLength);
                leftInd = i - (longestSubstring - 1)/2;
                rightInd = i + longestSubstring/2;
            }
        }
        return s.substring(leftInd, rightInd + 1);
    }

    private int middleOut(int left, int right, String s) {
        int longest = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            longest = right - left + 1;
            left--;
            right++;
        }
        return longest;
    }
}