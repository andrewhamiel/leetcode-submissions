class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        StringBuilder firstNum = new StringBuilder(num1);
        StringBuilder secondNum = new StringBuilder(num2);

        firstNum.reverse();
        secondNum.reverse();

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < num1.length() + num2.length(); i++) result.append('0');

        for(int place2 = 0; place2 < secondNum.length(); place2++) {
            int secondDigit = secondNum.charAt(place2) - '0';
            for(int place1 = 0; place1 < firstNum.length(); place1++) {
                int firstDigit = firstNum.charAt(place1) - '0';
                int currPos = place1 + place2;
                int carry = result.charAt(currPos) - '0';
                //ones digit
                int product = firstDigit * secondDigit + carry;
                result.setCharAt(currPos, (char)((product % 10) +'0'));
                //tens digit
                carry = result.charAt(currPos + 1) - '0';
                result.setCharAt(currPos + 1, (char)((product / 10 + carry) + '0'));
            }
        }

        //handle leading zero
        if(result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);

        result.reverse();
        return result.toString();
    }
}