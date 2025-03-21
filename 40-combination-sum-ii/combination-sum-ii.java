class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;
    private int target = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //Combinations -> order does not matter

        this.candidates = candidates;
        this.target = target;

        backtrack(0, 0, new ArrayList<>());    
        return result;
    }

    private void backtrack(int ind, int sum, List<Integer> list) {
        //Base cases
        if(sum == target) result.add(new ArrayList<>(list));
        if(ind == candidates.length || sum > target) return;

        for(int i = ind; i < candidates.length; i++) {
            if(i == ind || candidates[i] != candidates[i - 1]) {
                list.add(candidates[i]);
                backtrack(i + 1, sum + candidates[i], list);
                list.remove(list.size() -1);
            }
        }
    }
}