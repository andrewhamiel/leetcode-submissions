class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> rightMap = Map.of(')', '(', ']', '[', '}', '{');
        
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(rightMap.containsKey(c)) {
                char leftChar = rightMap.get(c);
                if(stack.isEmpty() || stack.removeFirst() != leftChar) return false;
            }else stack.addFirst(c);
        }
        return stack.isEmpty();
    }
}