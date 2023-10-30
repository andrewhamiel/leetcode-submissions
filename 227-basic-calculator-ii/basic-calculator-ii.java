class Solution {
    public int calculate(String s) {
        int currNumber = 0;
        char operation = '+';
        int ans = 0;
        int prevNumber = 0;
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(Character.isDigit(c)){
                currNumber*= 10;
                currNumber+= (int)(c - '0');
            } 
            if(i == s.length() - 1 || (!Character.isWhitespace(c) && !Character.isDigit(c))){
                if(operation == '+' || operation == '-'){
                    if(operation == '-') currNumber*= -1;
                    ans+= prevNumber;
                    prevNumber = currNumber;
                }else if(operation == '*') {
                    prevNumber*= currNumber;
                }else if(operation == '/') {
                    prevNumber/= currNumber;
                }
                operation = s.charAt(i);
                currNumber = 0;
            }
        }
        ans+= prevNumber;
        return ans;
    }
}