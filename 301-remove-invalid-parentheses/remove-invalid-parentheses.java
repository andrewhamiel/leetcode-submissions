class Solution {
    private Set<String> seen = new HashSet<>();
    private String s = "";
    private int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        backtrack(new StringBuilder(), 0, 0, 0, 0);
        return new ArrayList<>(seen);
    }

    private void backtrack(StringBuilder sb, int ind, int leftCount, int rightCount, int removed) {
        //0. Exit condition/base case
        if(ind == s.length()) {
            if(leftCount == rightCount && removed <= minRemoved) {
                if(removed < minRemoved) {
                    minRemoved = removed;
                    seen = new HashSet<>();
                }
                seen.add(sb.toString());
            }
            return;
        }
        
        int currLength = sb.length();
        char c = s.charAt(ind);

        //3 Cases
        //1. Left Paren - Add, Remove
        //2. Right Paren - Attempt to Add, Remove
        //3. All other chars - Add
        if(c == '(') {
            //Add
            sb.append(c);
            backtrack(sb, ind + 1, leftCount + 1, rightCount, removed);
            sb.deleteCharAt(currLength);
            //Remove
            backtrack(sb, ind + 1, leftCount, rightCount, removed + 1);
        }else if(c == ')') {
            //Attempt to add
            if(leftCount > rightCount) {
                sb.append(c);
                backtrack(sb, ind + 1, leftCount, rightCount + 1, removed);
                sb.deleteCharAt(currLength);
            }
            //Remove
            backtrack(sb, ind + 1, leftCount, rightCount, removed + 1);
        }else {
            //Add
            sb.append(c);
            backtrack(sb, ind + 1, leftCount, rightCount, removed);
            sb.deleteCharAt(currLength);
        }
    }
}