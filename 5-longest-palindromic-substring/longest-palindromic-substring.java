class Solution {
    public String longestPalindrome(String s) {
        int longest = 0, leftInd = 0, rightInd = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            int oddLength = middleOut(i, i, s);
            int evenLength = middleOut(i, i + 1, s);
            if(oddLength > longest || evenLength > longest) {
                longest = Math.max(oddLength, evenLength);
                leftInd = i - (longest - 1)/2;
                rightInd = i + longest/2;
            }
        }
        return s.substring(leftInd, rightInd + 1);
    }

    private int middleOut(int left, int right, String s) {
        int longest = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            longest = right - left + 1;
            left--;
            right++;
        }
        return longest;
    }
}