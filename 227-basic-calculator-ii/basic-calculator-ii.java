class Solution {
    public int calculate(String s) {
        char op = '+';
        int curr = 0, prev = 0, result = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr*= 10;
                curr+= c - '0';
            }
            if(i == s.length() - 1 || (!Character.isDigit(c) && !Character.isWhitespace(c))) {
                if(op == '+' || op == '-') {                   
                    if(op == '-') curr*= -1;
                    result+= prev;
                    prev = curr;
                }else if(op == '*') prev*= curr;
                else if(op == '/') prev/= curr;

                op = c;
                curr = 0;
            }
        }

        //Add remaining prev
        result+= prev;
        return result;
    }
}