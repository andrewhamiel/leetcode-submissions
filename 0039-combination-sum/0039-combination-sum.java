class Solution {
    List<List<Integer>> result = new ArrayList();
    int[] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(0, target, new ArrayList());
        return result;
    }
    
    private void dfs(int i, int target, List<Integer> comb){
        if(target == 0){
            result.add(new ArrayList(comb));
            return;
        }
        if(target < 0) return;
        
        for(int start = i; start < candidates.length; start++){
            comb.add(candidates[start]);
            dfs(start, target - candidates[start], comb);
            comb.remove(comb.size() - 1);
        }
    }
}