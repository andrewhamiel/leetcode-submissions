class Solution {
    public int myAtoi(String input) {
        int sign = 1, ind = 0;
        long result = 0;
        //1. Whitespace
        input = input.trim();

        //2. Sign
        if (ind < input.length() && input.charAt(ind) == '+') {
            sign = 1;
            ind++;
        } else if (ind < input.length() && input.charAt(ind) == '-') {
            sign = -1;
            ind++;
        }

        //3. Digits
        while (ind < input.length() && Character.isDigit(input.charAt(ind))) {
            result*= 10;
            result+= (input.charAt(ind++) - '0');
            if(result > Integer.MAX_VALUE) break; //Out of bounds
        }

        //4. Rounding
        result*= sign;
        if (result > Integer.MAX_VALUE ||result < Integer.MIN_VALUE)  {
            return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) result;
    }
}