class Solution {
    public int[] twoSum(int[] nums, int target) {
        // find the first number thats smaller or equal to the target
        int left = 0, right = nums.length - 1, potentialMax = target - nums[0];
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(nums[mid] <= potentialMax) left = mid;
            else right = mid;
        }
        if(nums[right] > potentialMax) right = left;
        left = 0;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target) return new int[]{left + 1, right + 1};
            else if(sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};       
    }
}