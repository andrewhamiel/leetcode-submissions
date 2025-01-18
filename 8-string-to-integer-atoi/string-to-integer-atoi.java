class Solution {
    public int myAtoi(String s) {
        //1. Whitespace
        s = s.trim();
        //2. Sign
        int ind = 0, sign = 1;
        if(ind < s.length() && (s.charAt(ind) == '+' || s.charAt(ind) == '-')) {
            sign = s.charAt(ind++) == '+' ? 1 : -1;
        }
        //3. Conversion
        long result = 0;
        while(ind < s.length() && Character.isDigit(s.charAt(ind))) {
            result*= 10;
            result+= s.charAt(ind++) - '0';
            if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) break;
        }
        result*= sign;
        //4. Rounding
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return result < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) result;
    }
}