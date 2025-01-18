class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //1. Sort to maintain relative order
        Arrays.sort(candidates);
        //2. Backtrack
        this.candidates = candidates;
        backtrack(0, target, new ArrayList<>());

        return result; 
    }

    private void backtrack(int ind, int sum, List<Integer> list) {
        //1. Base cases
        if(sum == 0) result.add(new ArrayList<>(list));
        if(sum < 0 || ind == candidates.length) return;

        //2. Backtrack
        for(int i = ind; i < candidates.length; i++) {
            if(i == ind || candidates[i] != candidates[i - 1]) {
                list.add(candidates[i]);
                backtrack(i + 1, sum - candidates[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}