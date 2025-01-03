class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        //Calculation is right -> left
        StringBuilder firstNum = new StringBuilder(num1), secondNum = new StringBuilder(num2);
        //Reverse to start with multiplying ones
        firstNum.reverse();
        secondNum.reverse();
        //Will need to worry about carries: 9 * 2 = 18, which is 8 carry 1
        //Initialize all digits to 0 because no carries seen yet
        //Why is length of result firstNum.length() + secondNum.length()?
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < firstNum.length() + secondNum.length(); i++) result.append('0');

        //Iterate through strings. Why do we need to start with place2 instead of place1?
        for(int place2 = 0; place2 < secondNum.length(); place2++) {
            int secondDigit = secondNum.charAt(place2) - '0';
            for(int place1 = 0; place1 < firstNum.length(); place1++) {
                int firstDigit = firstNum.charAt(place1) - '0';

                int currPos = place1 + place2;
                int carry = result.charAt(currPos) - '0';
                int product = firstDigit * secondDigit + carry;
                //Set ones digit
                result.setCharAt(currPos, (char) ((product % 10) + '0'));
                //Set tens digit
                carry = result.charAt(currPos + 1) - '0';
                result.setCharAt(currPos + 1, (char) ((product / 10 + carry) + '0'));
            }
        }

        //If there is a leading zero because no carry existed, remove it. Why?
        if(result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);

        //Reverse to restore to original order
        result.reverse();
        return result.toString();
    }
}