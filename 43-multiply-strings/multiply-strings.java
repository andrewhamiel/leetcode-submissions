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

        for(int place1 = 0; place1 < firstNum.length(); place1++) {
            int firstDigit = firstNum.charAt(place1) - '0';
            int carry = 0;
            for(int place2 = 0; place2 < secondNum.length(); place2++) {
                int secondDigit = secondNum.charAt(place2) - '0';

                int currPos = place1 + place2;
                int currSumAtPos = result.charAt(currPos) - '0';

                int product = firstDigit * secondDigit + currSumAtPos + carry;
                result.setCharAt(currPos, (char) ((product % 10) + '0'));
                carry = product / 10;
            }
            //Handle remaining carry
            int carryPos = place1 + secondNum.length();
            int existingCarry = result.charAt(carryPos) - '0';
            result.setCharAt(carryPos, (char)((existingCarry + carry) + '0'));
        }

        //If there is a leading zero because no carry existed, remove it. Why?
        if(result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);

        //Reverse to restore to original order
        result.reverse();
        return result.toString();
    }
}