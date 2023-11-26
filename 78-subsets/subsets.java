class Solution {
    Set<List<Integer>> result = new HashSet<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void backtrack(int ind, List<Integer> subset){
        //0. Exit condition
        if(ind == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        //no op
        backtrack(ind + 1, subset);
        for(int i = ind; i < nums.length; i++){
            subset.add(nums[i]);
            backtrack(i + 1, subset);
            subset.remove(subset.size() - 1);
        }
        
    }
}