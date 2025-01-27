class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> rightMapping = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(rightMapping.containsKey(c)) {
                if(stack.isEmpty() || stack.removeFirst() != rightMapping.get(c)) return false;
            }else stack.addFirst(c);
        }
        return stack.isEmpty();
    }
}