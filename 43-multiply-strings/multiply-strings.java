class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        StringBuilder firstNumber = new StringBuilder(num1), secondNumber = new StringBuilder(num2);

        //1. Reverse both numbers
        firstNumber.reverse();
        secondNumber.reverse();

        //2. Store multiplication result of each digit of secondNumber with firstNumber
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < firstNumber.length() + secondNumber.length(); i++) {
            result.append(0);
        }

        for(int place2 = 0; place2 < secondNumber.length(); place2++) {
            int digit2 = secondNumber.charAt(place2) - '0';

            //for each digit in second num multiply by all digits in firstNum
            for(int place1 = 0; place1 < firstNumber.length(); place1++) {
                int digit1 = firstNumber.charAt(place1) - '0';

                //number of zeroes depends on place1 and place2
                int currentPos = place1 + place2;

                int carry = result.charAt(currentPos) - '0';
                int product = digit1 * digit2 + carry;

                //Set ones place of multiplication result
                result.setCharAt(currentPos, (char) (product % 10 + '0'));

                //Carry tens place of multiplication result
                carry = (result.charAt(currentPos + 1) - '0') + product/10;
                result.setCharAt(currentPos + 1, (char) (carry + '0'));
            }
        }

        //Pop excess 0 from end of result
        if(result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);

        result.reverse();
        return result.toString();
    }
}