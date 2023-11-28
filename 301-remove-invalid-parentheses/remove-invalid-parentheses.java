class Solution {
    Set<String> result = new HashSet<>();
    int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        helper(0, 0, 0, 0, s, new StringBuilder());
        return new ArrayList<>(result);    
    }

    private void helper(int ind, int leftCount, int rightCount, int removed, String s, StringBuilder sb){
        if(ind == s.length()){
            if(leftCount == rightCount && removed <= minRemoved){
                if(removed < minRemoved){
                    result = new HashSet<>();
                    minRemoved = removed;
                }
                result.add(sb.toString());
            }
            return;
        }
        int currLength = sb.length();

        if(s.charAt(ind) == '('){
            sb.append(s.charAt(ind));
            helper(ind + 1, leftCount + 1, rightCount, removed, s, sb); //add
            sb.deleteCharAt(currLength);
            helper(ind + 1, leftCount, rightCount, removed + 1, s, sb); //remove
        }else if(s.charAt(ind) == ')'){
            if(leftCount > rightCount){
                sb.append(s.charAt(ind));
                helper(ind + 1, leftCount, rightCount + 1, removed, s, sb); //add
                sb.deleteCharAt(currLength);
            }
            helper(ind + 1, leftCount, rightCount, removed + 1, s, sb); //remove
        }else{
            sb.append(s.charAt(ind));
            helper(ind + 1, leftCount, rightCount, removed, s, sb);
            sb.deleteCharAt(currLength);
        }
    }
}