class Solution {
    private Set<String> result = new HashSet<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, n);
        return new ArrayList<>(result);    
    }

    private void backtrack(StringBuilder sb, int leftCount, int rightCount) {
        //1. Exit condition
        if(leftCount == 0 && rightCount == 0) {
            result.add(sb.toString());
            return;
        }

        int currLength = sb.length();

        //2. Add left if available
        if(leftCount > 0) {
            sb.append('(');
            backtrack(sb, leftCount - 1, rightCount);
            sb.deleteCharAt(currLength);
        }       

        //3. Add right if valid
        if(leftCount < rightCount) {
            sb.append(')');
            backtrack(sb, leftCount, rightCount - 1);
            sb.deleteCharAt(currLength);
        }
    }
}