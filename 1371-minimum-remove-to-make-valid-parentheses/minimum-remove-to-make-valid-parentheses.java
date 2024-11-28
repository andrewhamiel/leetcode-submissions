class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> leftParens = new ArrayDeque<>();
        Set<Integer> toBeRemoved = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') leftParens.addFirst(i);
            else if(c == ')') {
                if(leftParens.isEmpty()) toBeRemoved.add(i);
                else leftParens.removeFirst();
            }
        }

        while(!leftParens.isEmpty()) toBeRemoved.add(leftParens.removeFirst());

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) if(!toBeRemoved.contains(i)) result.append(s.charAt(i));
        
        return result.toString();
    }
}