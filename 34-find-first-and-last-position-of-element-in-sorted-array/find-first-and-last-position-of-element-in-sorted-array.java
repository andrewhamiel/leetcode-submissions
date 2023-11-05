class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = binarySearch(nums, target, true);
        if(firstIndex == -1) return new int[]{-1, -1};
        int secondIndex = binarySearch(nums, target, false);
        return new int[]{firstIndex, secondIndex};
    }

    private int binarySearch(int[] nums, int target, boolean isLeft){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isLeft){
                if(nums[mid] == target && (mid == 0 || nums[mid-1] != target)) return mid;
                else if(nums[mid] >= target) right = mid - 1;
                else left = mid + 1;
            }else{
                if(nums[mid] == target && (mid == nums.length - 1 || nums[mid+1] != target)) return mid;
                else if(nums[mid] <= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}