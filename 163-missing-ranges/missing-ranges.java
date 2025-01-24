class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();

        //1. Base case
        if(nums == null || nums.length == 0) return Arrays.asList(Arrays.asList(lower, upper));
        //2. lower < nums[0]
        if(lower < nums[0]) result.add(Arrays.asList(lower, nums[0] - 1));
        //3. Middle nums
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] > 1) result.add(Arrays.asList(nums[i - 1] + 1, nums[i] - 1));
        }
        //4. nums[nums.length - 1] < upper
        if(nums[nums.length - 1] < upper) result.add(Arrays.asList(nums[nums.length - 1] + 1, upper));

        return result;
    }
}