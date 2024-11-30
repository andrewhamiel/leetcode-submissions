class Solution {
    public String longestPalindrome(String s) {
        int leftInd = 0, rightInd = 0, longestLength = 0;
        for(int i = 0; i < s.length(); i++) {
            int oddLength = middleOut(i, i, s);
            int evenLength = middleOut(i, i + 1, s);
            if(oddLength > longestLength || evenLength > longestLength) {
                longestLength = Math.max(oddLength, evenLength);
                leftInd = i - (longestLength - 1)/2;
                rightInd = i + longestLength/2;
            }
        }
        return s.substring(leftInd, rightInd + 1);
    }

    private int middleOut(int left, int right, String s) {
        int result = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result = right - left + 1;
            left--;
            right++;
        }
        return result;
    }
}