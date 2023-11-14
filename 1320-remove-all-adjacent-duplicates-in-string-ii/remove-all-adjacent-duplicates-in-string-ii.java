class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty() || stack.peekFirst().getKey() != s.charAt(i)) stack.addFirst(new Pair<>(s.charAt(i), 1));
            else{
                Pair<Character, Integer> p = stack.removeFirst();
                if(p.getValue() + 1 < k) stack.addFirst(new Pair<>(p.getKey(), p.getValue() + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair<Character, Integer> p = stack.removeLast();
            int count = p.getValue();
            while(count-- > 0) sb.append(p.getKey());
        }
        return sb.toString();
    }
}