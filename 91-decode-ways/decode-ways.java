class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        int twoBack = 1, oneBack = 1;
        for(int i = 1; i < s.length(); i++) {
            int current = 0;
            if(s.charAt(i) != '0') current = oneBack;

            int tensDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if(tensDigit >= 10 && tensDigit <= 26) current+= twoBack;

            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}