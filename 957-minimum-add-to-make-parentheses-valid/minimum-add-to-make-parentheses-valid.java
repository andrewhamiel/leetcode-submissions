class Solution {
    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        for(Character c : s.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty()) count++;
                else stack.removeFirst();
            }else if(c == '(') stack.push(c);
        }
        return count + stack.size();
    }
}