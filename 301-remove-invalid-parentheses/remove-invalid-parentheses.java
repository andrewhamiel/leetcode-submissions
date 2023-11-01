class Solution {
    Set<String> validStrings = new HashSet<>();
    int minRemoved = Integer.MAX_VALUE;
    
    public List<String> removeInvalidParentheses(String s) {
        helper(s, new StringBuilder(), 0, 0, 0, 0);
        return new ArrayList<>(validStrings);
    }

    private void helper(String s, StringBuilder expression, int ind, int removed, int leftCount, int rightCount){
        if(ind == s.length()){
            if(removed <= minRemoved && leftCount == rightCount){
                if(removed < minRemoved){
                    minRemoved = removed;
                    validStrings = new HashSet<>();
                }
                validStrings.add(expression.toString());
            }
        }else{
            //Case 1: '('
            char c = s.charAt(ind);
            int currLength = expression.length();
            if(c == '('){
                //Try both adding and removing
                expression.append(c);
                helper(s, expression, ind+1, removed, leftCount+1, rightCount); //adding
                expression.deleteCharAt(currLength);
                helper(s, expression, ind+1, removed+1, leftCount, rightCount); //removing
            }
            //Case 2: ')'
            else if(c == ')'){
                //if not enough leftCount, must remove
                if(leftCount <= rightCount){
                    helper(s, expression, ind+1, removed+1, leftCount, rightCount);
                }else{
                    //try adding and removing
                    expression.append(c);
                    helper(s, expression, ind+1, removed, leftCount, rightCount+1); //adding
                    expression.deleteCharAt(currLength);
                    helper(s, expression, ind+1, removed+1, leftCount, rightCount); //removing
                }
            }
            //Case 3: Anything else: add
            else{
                expression.append(c);
                helper(s, expression, ind+1, removed, leftCount, rightCount);
                expression.deleteCharAt(currLength);
            }
        }
    }
}