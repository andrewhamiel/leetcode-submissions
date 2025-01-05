class Solution {
    public int myAtoi(String s) {
        int sign = 1, ind = 0;
        long result = 0;
        //1. Whitespace
        s = s.trim();

        //2. Sign
        if(ind < s.length() && s.charAt(ind) == '+') ind++;
        else if(ind < s.length() && s.charAt(ind) == '-') {
            sign = -1;
            ind++;
        }

        //3. Conversion
        while(ind < s.length() && Character.isDigit(s.charAt(ind)) && result < Integer.MAX_VALUE) {
            result*= 10;
            result+= s.charAt(ind++) - '0';
        }

        //4. Round down
        result*= sign;
        if(result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return result < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return (int) result;
    }
}