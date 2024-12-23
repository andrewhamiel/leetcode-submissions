class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        StringBuilder firstNum = new StringBuilder(num1), secondNum = new StringBuilder(num2);

        //Reverse strings
        firstNum.reverse();
        secondNum.reverse();

        //Initialize result with all 0 digits to start
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < firstNum.length() + secondNum.length(); i++) result.append("0");

        for(int place2 = 0; place2 < secondNum.length(); place2++) {
            int secondDigit = secondNum.charAt(place2) - '0';
            
            for(int place1 = 0; place1 < firstNum.length(); place1++) {
                int firstDigit = firstNum.charAt(place1) - '0';

                int currPos = place1 + place2;
                int carry = result.charAt(currPos) - '0';
                int product = firstDigit * secondDigit + carry;
                
                //Set ones digit
                result.setCharAt(currPos, (char)((product % 10) + '0'));
                //Set tens digit
                carry = (result.charAt(currPos + 1) - '0') + product/10;
                result.setCharAt(currPos + 1, (char) (carry + '0'));
            }
        }

        //Remove 0 if last digit
        if(result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);

        result.reverse();
        return result.toString();
    }
}