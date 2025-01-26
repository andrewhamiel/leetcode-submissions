class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> rightMapping = Map.of(')', '(', '}', '{', ']', '[');
        Deque<Character> leftChars = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if(rightMapping.containsKey(c)){
                if(leftChars.isEmpty() || rightMapping.get(c) != leftChars.peekFirst()) return false;
                else leftChars.removeFirst();
            }else leftChars.addFirst(c);
        }
        return leftChars.isEmpty();
    }
}