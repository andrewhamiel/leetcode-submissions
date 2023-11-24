class Solution {
    public String addStrings(String num1, String num2) {
        int ptr1 = num1.length() - 1, ptr2 = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(ptr1 >= 0 || ptr2 >= 0){
            int sum = 0;
            if(ptr1 >= 0 && ptr2 >= 0){
                int c1 = (int)(num1.charAt(ptr1--) - '0'), c2 = (int)(num2.charAt(ptr2--) - '0');
                sum = c1 + c2 + carry;
                result.append(sum % 10);
                carry = sum/10;
            }else if(ptr1 >= 0){
                int c1 = (int)(num1.charAt(ptr1--) - '0');
                sum = c1 + carry;
                result.append(sum % 10);
                carry = sum/10;
            }else if(ptr2 >= 0){
                int c2 = (int)(num2.charAt(ptr2--) - '0');
                sum = c2 + carry;
                result.append(sum % 10);
                carry = sum/10;
            }
        }
        if(carry != 0) result.append(carry);
        return result.reverse().toString();
    }
}