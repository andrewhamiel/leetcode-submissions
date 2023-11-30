class Solution {
    public int missingElement(int[] nums, int k) {
        if(k > missingNums(nums, nums.length - 1)) return nums[nums.length - 1] + k - missingNums(nums, nums.length - 1);

        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(missingNums(nums, mid) < k) left = mid + 1;
            else right = mid;
        }
        return nums[left - 1] + k - missingNums(nums, left - 1);
    }

    private int missingNums(int[] nums, int ind){
        return nums[ind] - nums[0] - ind;
    }
}