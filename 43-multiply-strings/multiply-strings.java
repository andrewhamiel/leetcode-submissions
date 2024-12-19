class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        StringBuilder firstNumber = new StringBuilder(num1), secondNumber = new StringBuilder(num2);

        //Reverse both numbers
        firstNumber.reverse();
        secondNumber.reverse();

        //Store 0 in each digit for result
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < firstNumber.length() + secondNumber.length(); i++) result.append('0');

        for(int place2 = 0; place2 < secondNumber.length(); place2++) {
            int digit2 = secondNumber.charAt(place2) - '0';

            for(int place1 = 0; place1 < firstNumber.length(); place1++) {
                int digit1 = firstNumber.charAt(place1) - '0';

                int currPos = place1 + place2;
                int carry = result.charAt(currPos) - '0';
                int product = digit1 * digit2 + carry;

                //Set ones digit
                result.setCharAt(currPos, (char) (product % 10 + '0'));
                //Set tens digit
                carry = (result.charAt(currPos + 1) - '0') + product/10;
                result.setCharAt(currPos + 1, (char)(carry + '0'));
            }
        }

        //Pop extra 0 at the end
        if(result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);

        result.reverse();
        return result.toString();
    }
}