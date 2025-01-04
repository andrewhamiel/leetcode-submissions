class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();
        backtrack(new StringBuilder(), 0, n, n);
        return result;
    }

    private void backtrack(StringBuilder sb, int ind, int leftCount, int rightCount) {
        //1. Exit condition
        if(leftCount == 0 && rightCount == 0) {
            result.add(sb.toString());
            return;
        }

        int currLength = sb.length();

        //2. If left parens left to add
        if(leftCount > 0) {
            sb.append('(');
            backtrack(sb, ind + 1, leftCount - 1, rightCount);
            sb.deleteCharAt(currLength);
        }
        //3. If valid to add right parens
        if(leftCount < rightCount) {
            sb.append(')');
            backtrack(sb, ind + 1, leftCount, rightCount - 1);
            sb.deleteCharAt(currLength);
        }
    }
}