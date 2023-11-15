class Solution {
    public int calculate(String s) {
        char operation = '+';
        int curr = 0, prev = 0, result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr*= 10;
                curr+= (int)(c - '0');
            }
            if(i == s.length() - 1 || (!Character.isDigit(c) && !Character.isWhitespace(c))){
                if(operation == '+' || operation == '-'){
                    if(operation == '-') curr*= -1;
                    result+= prev;
                    prev = curr;
                }else if(operation == '*') prev*= curr;
                else if(operation == '/') prev/= curr;
                curr = 0;
                operation = c;
            }
        }
        result+= prev;
        return result;
    }
}