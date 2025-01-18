class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0, sign = 1, result = 0;
        for(char c : s.toCharArray()) {
            //1. Digit
            //2. Addition or Subtraction
            //3. Left paren
            //4. Right paren
            if(Character.isDigit(c)) {
                operand*= 10;
                operand+= c - '0';
            }else if(c == '+' || c == '-') {
                result+= operand * sign;
                sign = c == '+' ? 1 : -1;
                operand = 0;
            }else if(c == '(') {
                stack.addFirst(result);
                stack.addFirst(sign);
                result = 0;
                sign = 1;
            }else if(c == ')') {
                result+= operand * sign;
                result*= stack.removeFirst(); //Sign
                result+= stack.removeFirst(); //Operand
                operand = 0;
            }
        }

        //Compute final operand
        result+= operand * sign;
        return result;
    }
}