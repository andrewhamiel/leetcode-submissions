class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> missingRanges = new ArrayList<>();

        if (nums.length == 0) {
            missingRanges.add(List.of(lower, upper));
            return missingRanges;
        }

        // Check for any missing numbers between the lower bound and nums[0].
        if (lower < nums[0]) missingRanges.add(List.of(lower, nums[0] - 1));

        // Check for any missing numbers between successive elements of nums.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] <= 1) continue;
            missingRanges.add(List.of(nums[i] + 1, nums[i + 1] - 1));
        }
        
        // Check for any missing numbers between the last element of nums and the upper bound.
        if (upper > nums[nums.length - 1]) missingRanges.add(List.of(nums[nums.length - 1] + 1, upper));

        return missingRanges;
    }
}