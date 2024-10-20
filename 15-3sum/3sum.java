class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) twoSumSorted(i + 1, -nums[i], nums, result); 
        }
        return result;
    }

    private void twoSumSorted(int i, int target, int[] nums, List<List<Integer>> result) {
        int j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum == target) {
                result.add(List.of(-target, nums[i++], nums[j]));
                while(i < j && nums[i] == nums[i - 1]) i++;
            }else if(sum < target) i++;
            else j--;
        }
    }
}