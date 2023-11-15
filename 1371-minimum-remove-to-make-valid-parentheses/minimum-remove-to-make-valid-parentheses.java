class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Set<Integer> toBeRemoved = new HashSet<>();
        int leftCount = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') left.addFirst(i);
            else if(c == ')'){
                if(!left.isEmpty()) left.removeFirst();
                else toBeRemoved.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()) toBeRemoved.add(left.removeLast());

        for(int i = 0; i < s.length(); i++){
            if(!toBeRemoved.contains(i)) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}