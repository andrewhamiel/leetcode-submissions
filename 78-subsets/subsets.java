class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());   
        return result; 
    }

    private void backtrack(int ind, int[] nums, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for(int i = ind; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}