class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if(sum < 10) return digits;
        }
        //If we are here, all digits were 9. new array with first digit 1
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}