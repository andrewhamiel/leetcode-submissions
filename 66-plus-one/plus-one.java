class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int carry = 0;
        boolean isBreakFound = false;
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i]+= carry;
            
            carry = digits[i] / 10;
            if(digits[i] < 10) break;
            digits[i]%= 10;
        }
        if(carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for(int i = 1; i < result.length; i++) result[i] = digits[i - 1];
            return result;
        }
        return digits;
    }
}