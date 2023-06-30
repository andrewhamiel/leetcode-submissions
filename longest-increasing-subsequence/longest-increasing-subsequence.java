class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subArr = new ArrayList<>();
        subArr.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > subArr.get(subArr.size() - 1)) subArr.add(nums[i]);
            else subArr.set(binarySearch(subArr, nums[i]), nums[i]);
        }
        return subArr.size();
    }

    private int binarySearch(List<Integer> subArr, int target){
        int left = 0, right = subArr.size() - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(subArr.get(mid) == target) return mid;
            else if(subArr.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}