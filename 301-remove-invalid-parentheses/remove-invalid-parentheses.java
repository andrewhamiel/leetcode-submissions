class Solution {
    Set<String> result = new HashSet<>();
    int minRemoved = Integer.MAX_VALUE;

    public List<String> removeInvalidParentheses(String s) {
        helper(0, 0, 0, 0, new StringBuilder(), s);
        return new ArrayList<>(result);
    }

    private void helper(int ind, int leftCount, int rightCount, int removed, StringBuilder sb, String s){
        if(ind >= s.length()){
            if(leftCount == rightCount && removed <= minRemoved){
                if(removed < minRemoved){
                    minRemoved = removed;
                    result = new HashSet<>();
                }
                result.add(sb.toString());
            }
            return;
        }

        int currLength = sb.length();

        if(s.charAt(ind) == '('){
            //try add and remove
            sb.append(s.charAt(ind));
            helper(ind + 1, leftCount + 1, rightCount, removed, sb, s);
            sb.deleteCharAt(currLength);
            helper(ind + 1, leftCount, rightCount, removed + 1, sb, s);
        }else if(s.charAt(ind) == ')'){
            //try add and remove if enough leftCount, just remove otherwise
            if(leftCount > rightCount){
                sb.append(s.charAt(ind));
                helper(ind + 1, leftCount, rightCount + 1, removed, sb, s);
                sb.deleteCharAt(currLength);
            }
            helper(ind + 1, leftCount, rightCount, removed + 1, sb, s); //remove
        }else{
            //for everything else, just add
            sb.append(s.charAt(ind));
            helper(ind + 1, leftCount, rightCount, removed, sb, s);
            sb.deleteCharAt(currLength);
        }
    }

}