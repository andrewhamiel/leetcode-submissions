class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickselect(int[] nums, int left, int right, int k){
        if(left == right) return nums[left];
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        pivotIndex = partition(nums, left, right, pivotIndex);
        if(pivotIndex == k) return nums[k];
        else if(pivotIndex < k){
            pivotIndex++;
            while(pivotIndex < k && nums[pivotIndex] == nums[pivotIndex - 1]) pivotIndex++;
            return quickselect(nums, pivotIndex, right, k);
        }else{
            pivotIndex--;
            while(pivotIndex > k && nums[pivotIndex] == nums[pivotIndex + 1]) pivotIndex--;
            return quickselect(nums, left, pivotIndex, k);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex){
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        pivotIndex = left;
        for(int i = left; i <= right; i++){
            if(nums[i] <= pivot) swap(nums, i, pivotIndex++);
        }
        return pivotIndex - 1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}