class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty() || stack.peekFirst().getKey() != s.charAt(i)) stack.addFirst(new Pair<>(s.charAt(i), 1));
            else{
                Pair<Character, Integer> p = stack.removeFirst();
                if(p.getValue() + 1 < k) stack.addFirst(new Pair<>(s.charAt(i), p.getValue() + 1));
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            Pair<Character, Integer> p = stack.removeLast();
            int count = p.getValue();
            while(count-- > 0) result.append(p.getKey());
        }
        return result.toString();
    }
}