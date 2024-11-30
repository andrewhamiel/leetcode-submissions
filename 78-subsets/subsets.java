class Solution {
    private Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return new ArrayList<>(result);
    }

    private void backtrack(int ind, int[] nums, List<Integer> list) {
        result.add(new ArrayList<>(list));

        for(int i = ind; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i + 1, nums, list);
            list.remove(list.size() -1);
        }
    }
}