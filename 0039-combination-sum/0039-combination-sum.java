class Solution {
    private List<List<Integer>> result = new ArrayList();
    private int[] candidates;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        dfs(0, target, new ArrayList());
        return result;
    }
    
    private void dfs(int start, int target, List<Integer> comb){
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList(comb));
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            comb.add(candidates[i]);
            dfs(i, target-candidates[i], comb);
            comb.remove(comb.size() - 1);
        }
    }
}