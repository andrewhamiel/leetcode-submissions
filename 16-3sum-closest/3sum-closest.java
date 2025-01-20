class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int closest = 100_000;
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int currSum = nums[i] + twoSumSorted(i + 1, nums, target - nums[i]);
                if(Math.abs(target - currSum) < Math.abs(target - closest)) closest = currSum;
            }
        }
        return closest;
    }

    private int twoSumSorted(int left, int[] nums, int target) {
        int right = nums.length - 1, closest = 100_000;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(Math.abs(target - sum) < Math.abs(target - closest)) closest = sum;

            if(sum == target) return closest;
            else if(sum < target) left++;
            else right--;
        }
        return closest;
    }
}