class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int operand = 0, result = 0, sign = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                operand*= 10;
                operand+= (c - '0');
            }else if(c == '+') {
                result+= sign * operand;
                sign = 1;
                operand = 0;
            }else if(c == '-') {
                result+= sign * operand;
                sign = -1;
                operand = 0;
            }else if(c == '(') {
                stack.addFirst(result);
                stack.addFirst(sign);
                sign = 1;
                result = 0;
            }else if(c == ')') {
                result+= sign * operand;
                result*= stack.removeFirst();
                result+= stack.removeFirst();
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}