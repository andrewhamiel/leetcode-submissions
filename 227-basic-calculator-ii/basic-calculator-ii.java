class Solution {
    public int calculate(String s) {
        int curr = 0, prev = 0, result = 0;
        char op = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr*= 10;
                curr+= (c - '0');

            }
            if(i == s.length() - 1 || (!Character.isDigit(c) && !Character.isWhitespace(c))){
                if(op == '+' || op == '-'){
                    result+= prev;
                    if(op == '-') curr*= -1;
                    prev = curr;
                }else if(op == '*') prev*= curr;
                else if(op == '/') prev/= curr;

                op = c;
                curr = 0;
            }
        }
        result+= prev;
        return result;
    }
}