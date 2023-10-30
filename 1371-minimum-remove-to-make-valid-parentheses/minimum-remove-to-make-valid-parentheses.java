class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toBeRemoved = new HashSet<>();
        Deque<Integer> openParens = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') openParens.addFirst(i);
            else if(s.charAt(i) == ')'){
                if(openParens.isEmpty()) toBeRemoved.add(i);
                else openParens.removeFirst();
            }
        }
        while(!openParens.isEmpty()) toBeRemoved.add(openParens.removeFirst());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) if(!toBeRemoved.contains(i)) sb.append(s.charAt(i));
        return sb.toString();
    }
}