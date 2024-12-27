class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens) {
            char c = token.charAt(0);
            //Handle negative numbers as well
            if(Character.isDigit(c) || token.length() > 1) stack.addFirst(Integer.parseInt(token));
            else {
                int num2 = stack.removeFirst(), num1 = stack.removeFirst();
                if(c == '+') stack.addFirst(num1 + num2);
                else if(c == '-') stack.addFirst(num1 - num2);
                else if(c == '*') stack.addFirst(num1 * num2);
                else if(c == '/') stack.addFirst(num1 / num2);
            }
        }

        int result = 0;
        while(!stack.isEmpty()) result+= stack.removeFirst();
        
        return result;
    }
}