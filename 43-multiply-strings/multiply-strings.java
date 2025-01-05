class Solution {
    public String multiply(String num1, String num2) {
        //Intuition: use elementary long multiplication
        //1. Base case
        if(num1.equals("0") || num2.equals("0")) return "0";

        //123 * 456
        //Start by multiplying last digits together first, work backwards
        //So to make this easier to iterate through, we can first reverse the strings
        StringBuilder firstNum = new StringBuilder(num1), secondNum = new StringBuilder(num2);

        firstNum.reverse();
        secondNum.reverse();

        //Length of result will be at most num1.length() + num2.length(). Last digit could potentially be 0, so range of valid lengths is [nums1.length() + nums2.length() - 1, nums1.length() + nums2.length()]
        //Initialize result, and set all of its digits initially to '0' so we can keep track of any carries that are a result of elementary multiplication
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < firstNum.length() + secondNum.length(); i++) result.append('0');

        //Now we will traverse through each number and perform elementary multiplication
        //Loop through second number first because this will make keeping track of the carry value much easier
        for(int place2 = 0; place2 < secondNum.length(); place2++) {
            int secondDigit = secondNum.charAt(place2) - '0';
            for(int place1 = 0; place1 < firstNum.length(); place1++) {
                int firstDigit = firstNum.charAt(place1) - '0';

                //To find carry and location where to insert in result, need current position
                int currPos = place1 + place2;
                int carry = result.charAt(currPos) - '0';
                int product = firstDigit * secondDigit + carry;
                //Set ones digit first because reverse order
                result.setCharAt(currPos, (char) ((product % 10) + '0'));
                //Set tens digit
                carry = result.charAt(currPos + 1) - '0'; //Tens carry
                result.setCharAt(currPos + 1, (char) ((product / 10 + carry) + '0'));
            }
        }

        //Handle leading zero if present
        if(result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);

        //Restore correct orientation
        result.reverse();
        return result.toString();
    }
}