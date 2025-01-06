class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(0, target, new ArrayList<>());
        return result;    
    }

    private void backtrack(int ind, int target, List<Integer> list) {
        //1. Base cases
        if(target < 0) return;
        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        //2. Backtrack
        for(int i = ind; i < candidates.length; i++) {
            if(i == ind || candidates[i] != candidates[i - 1]) {
                list.add(candidates[i]);
                backtrack(i + 1, target - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}