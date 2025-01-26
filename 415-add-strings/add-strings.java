class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int firstInd = num1.length() - 1, secondInd = num2.length() - 1;
        while(firstInd >= 0 || secondInd >= 0) {
            if(firstInd >= 0 && secondInd >= 0) {
                int firstNum = num1.charAt(firstInd--) - '0';
                int secondNum = num2.charAt(secondInd--) - '0';
                int val = firstNum + secondNum + carry;
                result.append((char)((val % 10) + '0'));
                carry = val / 10;
            }else if(firstInd >= 0) {
                int firstNum = num1.charAt(firstInd--) - '0';
                int val = firstNum + carry;
                result.append((char)((val % 10) + '0'));
                carry = val / 10;
            }else if(secondInd >= 0) {
                int secondNum = num2.charAt(secondInd--) - '0';
                int val = secondNum + carry;
                result.append((char)((val % 10) + '0'));
                carry = val / 10;
            }
        }
        //Last carry if present
        if(carry > 0) {
            result.append((char)(carry + '0'));
        }
        
        result.reverse();
        return result.toString();
    }
}