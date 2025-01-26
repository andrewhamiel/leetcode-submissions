class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            if(sum < 10) return digits;
            carry = sum / 10;
        }
        //All numbers '9' if we reach this point
        int[] result = new int[digits.length + 1];
        result[0] = 1; 
        return result;
    }
}