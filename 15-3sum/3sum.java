class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) twoSumSorted(i, nums, -nums[i], result);
        }
        return result;
    }

    private void twoSumSorted(int i, int[] nums, int target, List<List<Integer>> result) {
        int left = i + 1, right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right]));
                while(left < right && nums[left] == nums[left - 1]) left++;
            }else if(sum < target) left++;
            else right--;
        }
    }
}