class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        backtrack(new StringBuilder(), n, n, result);
        return new ArrayList<>(result);    
    }

    private void backtrack(StringBuilder sb, int leftCount, int rightCount, Set<String> result) {
        //1. Exit condition
        if(leftCount == 0 && rightCount == 0) {
            result.add(sb.toString());
            return;
        }

        int currLength = sb.length();

        //2. Add left if any remaining
        if(leftCount > 0) {
            sb.append('(');
            backtrack(sb, leftCount - 1, rightCount, result);
            sb.deleteCharAt(currLength);
        }
        //3. Add right if valid
        if(leftCount < rightCount) {
            sb.append(')');
            backtrack(sb, leftCount, rightCount - 1, result);
            sb.deleteCharAt(currLength);
        }
    }
}