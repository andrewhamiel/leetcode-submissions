class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens) {
            char c = token.charAt(0);
            if(Character.isDigit(c) || token.length() > 1) stack.addFirst(Integer.parseInt(token));
            else {
                int secondNum = stack.removeFirst(), firstNum = stack.removeFirst();
                if(c == '+') stack.addFirst(firstNum + secondNum);
                else if(c == '-') stack.addFirst(firstNum - secondNum);
                else if(c == '*') stack.addFirst(firstNum * secondNum);
                else if(c == '/') stack.addFirst(firstNum / secondNum);
            }
        }

        int result = 0;
        while(!stack.isEmpty()) result+= stack.removeFirst();
        return result;
    }
}