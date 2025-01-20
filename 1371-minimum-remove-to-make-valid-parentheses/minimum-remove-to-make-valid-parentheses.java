class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toBeRemoved = new HashSet<>();
        Deque<Integer> leftParens = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') leftParens.add(i);
            else if(c == ')') {
                if(!leftParens.isEmpty()) leftParens.removeFirst();
                else toBeRemoved.add(i);
            }
        }

        while(!leftParens.isEmpty()) toBeRemoved.add(leftParens.removeFirst());

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!toBeRemoved.contains(i)) result.append(s.charAt(i));
        }
        return result.toString();
    }
}