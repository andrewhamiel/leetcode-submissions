class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peekFirst().getKey() == c){
                Pair<Character, Integer> p = stack.removeFirst();
                if(p.getValue() + 1 < k) stack.addFirst(new Pair<>(c, p.getValue() + 1));
            }else stack.addFirst(new Pair<>(c, 1));
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