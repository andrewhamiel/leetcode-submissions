class Solution {
    private Set<String> result = new HashSet<>();
    private String s = "";
    private int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        backtrack(new StringBuilder(), 0, 0, 0, 0);
        return new ArrayList<>(result);   
    }

    private void backtrack(StringBuilder sb, int ind, int leftCount, int rightCount, int removed) {
        //1. Exit condition
        if(ind == s.length()) {
            if(leftCount == rightCount && removed <= minRemoved) {
                if(removed < minRemoved) {
                    minRemoved = removed;
                    result = new HashSet<>();
                }
                result.add(sb.toString());
            }
            return;
        }

        int currLength = sb.length();
        char c = s.charAt(ind);

        //2. Left paren: Add, remove
        //3. Right paren: Add if valid, remove
        //4. Other chars: Add
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