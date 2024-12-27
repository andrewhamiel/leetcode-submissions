class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token : tokens) {
            char c = token.charAt(0);
            //Handle negative numbers as well
            if(Character.isDigit(c) || token.length() > 1) stack.addFirst(Integer.parseInt(token));
            else {
                int num1 = stack.removeFirst(), num2 = stack.removeFirst();
                if(token.equals("+")) stack.addFirst(num2 + num1);
                else if(token.equals("-")) stack.addFirst(num2 - num1);
                else if(token.equals("*")) stack.addFirst(num2 * num1);
                else if(token.equals("/")) stack.addFirst(num2 / num1);
            }
        }

        int result = 0;
        while(!stack.isEmpty()) result+= stack.removeFirst();
        
        return result;
    }
}