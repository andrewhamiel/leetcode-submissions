class Solution {
    public String longestPalindrome(String s) {
        int longest = 0, left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            int oddLength = middleOut(i, i, s);
            int evenLength = middleOut(i, i+1, s);
            if(oddLength > longest || evenLength > longest){
                longest = Math.max(oddLength, evenLength);
                left = i - (longest - 1)/2;
                right = i + (longest/2);
            }
        }
        return s.substring(left, right + 1);
    }

    private int middleOut(int left, int right, String s){
        int length = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) length = right - left - 1;
        return length;
    }
}