class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return new ArrayList();
        
        List<String> result = new ArrayList();
        dfs(n, n, new StringBuilder(), result, 0);
        return result;
    }
    
    private void dfs(int left, int right, StringBuilder sb, List<String> result, int start){
        if(left == 0 && right == 0){
            result.add(sb.toString());           
            return;
        }

        int currLength = sb.length();
        if(left > 0) {
            sb.append("(");
            dfs(left-1, right, sb, result, start + 1);
            sb.deleteCharAt(currLength); 
        } 
        if(right > left){
            sb.append(")");
            dfs(left, right - 1, sb, result, start + 1);
            sb.deleteCharAt(currLength); 
        }        
    }

}