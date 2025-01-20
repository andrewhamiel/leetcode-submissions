class Solution {
    public int numDecodings(String s) {
        //1. Base case
        if(s.charAt(0) == '0') return 0;

        //Kadane's Algo
        int oneBack = 1, twoBack = 1, prevDigit = s.charAt(0) - '0';
        for(int i = 1; i < s.length(); i++) {
            int currDigit = s.charAt(i) - '0';
            int currWays = 0;
            if(currDigit != 0) currWays = oneBack;

            int tensDigit = prevDigit * 10 + currDigit;
            if(tensDigit >= 10 && tensDigit <= 26) currWays+= twoBack;

            prevDigit = currDigit;
            twoBack = oneBack;
            oneBack = currWays;
        }
        return oneBack;
    }
}