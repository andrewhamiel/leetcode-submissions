class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int closest = twoSumSorted(i + 1, nums, nums[i], target);
                if(Math.abs(target - closest) < Math.abs(minDiff)) minDiff = target - closest;
            }
        }
        return target - minDiff;
    }

    private int twoSumSorted(int left, int[] nums, int currSum, int target) {
        int right = nums.length - 1, minDiff = Integer.MAX_VALUE;
        while(left < right) {
            int sum = currSum + nums[left] + nums[right];
            if(Math.abs(target - sum) < Math.abs(minDiff)) minDiff = target - sum;
            if(sum <= target) left++;
            else right--;
        }
        return target - minDiff;
    }
}