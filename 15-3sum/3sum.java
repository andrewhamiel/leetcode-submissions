class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length && nums[i] <= 0; i++){
            if(i == 0 || nums[i] != nums[i - 1]) twoSumSorted(i, nums, result);
        }
        return result;
    }

    private void twoSumSorted(int i, int[] nums, List<List<Integer>> result){
        int left = i + 1, right = nums.length - 1;
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum == 0){
                result.add(List.of(nums[i], nums[left++], nums[right--]));
                //Filter out duplicates on left hand side
                while(left < right && nums[left] == nums[left - 1]) left++;
            }else if(sum < 0) left++;
            else right--;
        }
    }
}