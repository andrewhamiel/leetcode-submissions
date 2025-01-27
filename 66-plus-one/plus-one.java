class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum  = digits[i] + carry;
            
            digits[i] = sum % 10;
            carry = sum / 10;
            if(sum < 10) return digits;
        }

        //If at this point, you have all 9s. New array adds a prefix 1 then returns all 0s after
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}