class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> rightMapping = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(rightMapping.containsKey(c)) {
                if(stack.isEmpty() || rightMapping.get(c) != stack.peekFirst()) return false;
                else stack.removeFirst();
            }else stack.addFirst(c);
        }
        return stack.isEmpty();
    }
}