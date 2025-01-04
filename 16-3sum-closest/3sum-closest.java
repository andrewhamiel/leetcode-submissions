class Solution {
    private int target = 0;
    private int result = 100_000;

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        this.target = target;
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) twoSumSorted(i + 1, nums, nums[i]);
        }  
        return result;  
    }

    private void twoSumSorted(int left, int[] nums, int currSum) {
        int right = nums.length - 1, closest = Integer.MAX_VALUE;
        while(left < right) {
            int sum = currSum + nums[left] + nums[right];
            if(Math.abs(target - sum) < Math.abs(target - result)) result = sum;
            if(sum <= target) left++;
            else right--;
        }
    }
}