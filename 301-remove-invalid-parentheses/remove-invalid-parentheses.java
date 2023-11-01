class Solution {
    Set<String> validStrings = new HashSet<>();
    int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        helper(s, new StringBuilder(), 0, 0, 0, 0);
        return new ArrayList<>(validStrings);
    }

    private void helper(String s, StringBuilder expr, int ind, int removed, int leftCount, int rightCount){
        if(ind == s.length()){
            if(removed <= minRemoved && leftCount == rightCount){
                if(removed < minRemoved){
                    validStrings = new HashSet<>();
                    minRemoved = removed;
                }
                validStrings.add(expr.toString());
            }
        }else{
            char c = s.charAt(ind);
            int currLength = expr.length();
            //Case 1: '(' - try adding and removing
            if(c == '('){
                expr.append(c);
                helper(s, expr, ind + 1, removed, leftCount + 1, rightCount); //add
                expr.deleteCharAt(currLength);
                helper(s, expr, ind + 1, removed + 1, leftCount, rightCount); //remove
            }else if(c == ')'){ //Case 2: ')' - check to see if enough left count. add and remove if enough, just remove if not
                if(leftCount > rightCount){
                    expr.append(c);
                    helper(s, expr, ind + 1, removed, leftCount, rightCount + 1); //add
                    expr.deleteCharAt(currLength);
                }
                helper(s, expr, ind + 1, removed + 1, leftCount, rightCount); //remove
            }else{ //Case 3: Everything else - add
                expr.append(c);
                helper(s, expr, ind + 1, removed, leftCount, rightCount);
                expr.deleteCharAt(currLength);
            }
            
            
        }
    }
}