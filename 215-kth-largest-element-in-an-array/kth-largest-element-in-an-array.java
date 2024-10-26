class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(0, nums.length - 1, nums, k - 1);
    }

    private int quickselect(int left, int right, int[] nums, int k) {
        if(left >= right) return nums[left];

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(left, right, nums, pivotIndex);

        if(pivotIndex == k) return nums[k];
        else if(pivotIndex < k) {
            pivotIndex++;
            while(pivotIndex < k && nums[pivotIndex] == nums[pivotIndex - 1]) pivotIndex++;
            return quickselect(pivotIndex, right, nums, k);
        }else{
            pivotIndex--;
            while(pivotIndex > k && nums[pivotIndex] == nums[pivotIndex + 1]) pivotIndex--;
            return quickselect(left, pivotIndex, nums, k);
        }
    }

    private int partition(int left, int right, int[] nums, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(pivotIndex, right, nums);
        int swapIndex = left;
        
        for(int i = left; i <= right; i++) {
            if(nums[i] > pivotValue) swap(swapIndex++, i, nums);
        }
        swap(swapIndex, right, nums);
        return swapIndex;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}