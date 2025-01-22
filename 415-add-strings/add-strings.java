class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int ptrA = num1.length() - 1, ptrB = num2.length() - 1;
        int carry = 0;
        while(ptrA >= 0 || ptrB >= 0) {
            if(ptrA >= 0 && ptrB >= 0) {
                int digit1 = num1.charAt(ptrA--) - '0';
                int digit2 = num2.charAt(ptrB--) - '0';
                int sum = digit1 + digit2 + carry;
                result.append((char) ((sum % 10) + '0'));
                carry = sum / 10;
            }else if(ptrA >= 0) {
                int digit1 = num1.charAt(ptrA--) - '0';
                int sum = digit1 + carry;
                result.append((char) ((sum % 10) + '0'));
                carry = sum / 10;
            }else if(ptrB >= 0) {
                int digit2 = num2.charAt(ptrB--) - '0';
                int sum = digit2 + carry;
                result.append((char) ((sum % 10) + '0'));
                carry = sum / 10;
            }
        }

        if(carry != 0) result.append((char)(carry + '0'));
        result.reverse();
        return result.toString();
    }
}