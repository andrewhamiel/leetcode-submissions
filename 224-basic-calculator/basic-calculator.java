class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0, result = 0, sign = 1;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                operand*= 10;
                operand+= (c - '0');
            }else if(c == '+') {
                result+= (operand * sign);
                operand = 0;
                sign = 1;
            }else if(c == '-') {
                result+= (operand * sign);
                operand = 0;
                sign = -1;
            }else if(c == '(') {
                stack.addFirst(result);
                stack.addFirst(sign);
                result = 0;
                sign = 1;
            }else if(c == ')') {
                result+= (operand * sign);
                result*= stack.removeFirst(); //Sign
                result+= stack.removeFirst(); //Operand
                operand = 0;
            }
        }
        return result + (operand * sign);
    }
}