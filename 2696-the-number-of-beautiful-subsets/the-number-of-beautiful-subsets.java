class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> hSet = new HashSet<>();
        return solve(nums, k, 0, hSet);
    }

    private int solve(int[] nums, int k, int ind, Set<Integer> hSet) {
        if (ind == nums.length) {
            if (hSet.size() > 0) return 1;
            return 0;
        }

        int take = 0, nottake = 0;
        nottake += solve(nums, k, ind + 1, hSet);

        if (!hSet.contains(nums[ind] - k)) {
            hSet.add(nums[ind]);
            take += solve(nums, k, ind + 1, hSet);
            // backtrack
            hSet.remove(nums[ind]);
        }

        return take + nottake;
    }
}