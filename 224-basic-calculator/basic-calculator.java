class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0, result = 0, sign = 1;
        for(char c : s.toCharArray()) {
            //1. Num
            //2. Sign
            //3. Left Paren
            //4. Right Paren
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

        result+= operand * sign;
        return result;
    }
}