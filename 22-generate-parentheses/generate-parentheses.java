class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        helper(n, n, new StringBuilder(), result, 0);
        return result;
    }

    private void helper(int leftCount, int rightCount, StringBuilder sb, List<String> result, int start){
        if(leftCount == 0 && rightCount == 0) {
            result.add(sb.toString());
            return;
        }

        int currLength = sb.length();
        if(leftCount > 0){
            sb.append("(");
            helper(leftCount - 1, rightCount, sb, result, start + 1);
            sb.deleteCharAt(currLength);
        }
        if(rightCount > leftCount){
            sb.append(")");
            helper(leftCount, rightCount - 1, sb, result, start + 1);
            sb.deleteCharAt(currLength);
        }
    }
}