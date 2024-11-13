class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] <= 0 && (i == 0 || nums[i] != nums[i - 1])) twoSumSorted(-nums[i], i + 1, nums, result);
        }
        return result;
    }

    private void twoSumSorted(int target, int ind, int[] nums, List<List<Integer>> result) {
        int left = ind, right = nums.length - 1;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == target) {
                result.add(Arrays.asList(-target, nums[left++], nums[right]));
                while(left < right && nums[left] == nums[left - 1]) left++;
            }else if(sum < target) left++;
            else right--;
        }
    }
}