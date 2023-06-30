class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > sub.get(sub.size() - 1)) sub.add(nums[i]);
            else sub.set(binarySearch(sub, nums[i]), nums[i]);
        }
        return sub.size();
    }

    private int binarySearch(List<Integer> nums, int target){
        int left = 0, right = nums.size() - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}