class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();
        backtrack(new StringBuilder(), n, n);
        return result;    
    }

    private void backtrack(StringBuilder sb, int leftCount, int rightCount) {
        //1. Exit condition
        if(leftCount == 0 && rightCount == 0) {
            result.add(sb.toString());
            return;
        }

        int currLength = sb.length();

        //2. Add left paren if any remaining
        if(leftCount > 0) {
            sb.append('(');
            backtrack(sb, leftCount - 1, rightCount);
            sb.deleteCharAt(currLength);
        }
        //3. Add right paren if valid to do so
        if(leftCount < rightCount) {
            sb.append(')');
            backtrack(sb, leftCount, rightCount - 1);
            sb.deleteCharAt(currLength);
        }
    }
}