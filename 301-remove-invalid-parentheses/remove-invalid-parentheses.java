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
        if(ind == s.length()) {
            if(leftCount == rightCount && removed <= minRemoved) {
                if(removed < minRemoved) {
                    seen = new HashSet<>();
                    minRemoved = removed;
                }
                seen.add(sb.toString());
            }
            return;
        }

        int currLength = sb.length();
        char c = s.charAt(ind);

        //1. ( - Add or do not add
        //2. )
        //3. Other chars - Add       
        if(c == '(') {
            //2. Add
            sb.append(c);
            backtrack(sb, ind + 1, leftCount + 1, rightCount, removed);
            sb.deleteCharAt(currLength);
            //Do not add
            backtrack(sb, ind + 1, leftCount, rightCount, removed + 1);
        }else if(c == ')') {
            if(rightCount >= leftCount) {
                //No add
                backtrack(sb, ind + 1, leftCount, rightCount, removed + 1);
            }else {
                //Add
                sb.append(c);
                backtrack(sb, ind + 1, leftCount, rightCount + 1, removed);
                sb.deleteCharAt(currLength);
                //No add
                backtrack(sb, ind + 1, leftCount, rightCount, removed + 1);
            }
        }else {
            sb.append(c);
            backtrack(sb, ind + 1, leftCount, rightCount, removed);
            sb.deleteCharAt(currLength);
        }
    }
}