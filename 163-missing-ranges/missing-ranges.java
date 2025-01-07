class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        //1. No input check
        if(nums == null || nums.length == 0) {
            result.add(Arrays.asList(lower, upper));
            return result;
        }

        //2. Lower bound check
        if(lower < nums[0]) result.add(Arrays.asList(lower, nums[0] - 1));

        //2. Middle range check
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] <= 1) continue;
            else result.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
        }
        //3. Upper bound check
        if(nums[nums.length - 1] < upper) result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));

        return result;
    }
}