class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) twoSumSorted(i + 1, -nums[i], nums);
        }    
        return result;
    }

    private void twoSumSorted(int left, int target, int[] nums) {
        int right = nums.length - 1;
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