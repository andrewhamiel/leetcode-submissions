class Solution {
    public int[] sortArray(int[] nums) {
        //max heapify
        for(int i = nums.length/2; i >= 0; i--){
            maxHeapify(nums, nums.length, i);
        }
        //swap first and last elements, heapify
        for(int i = nums.length - 1; i >= 0; i--){
            //swap
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            //heapify
            maxHeapify(nums, i, 0);
        }
        return nums;
    }
    
    private void maxHeapify(int[] nums, int heapSize, int index){
        int left = 2 * index, right = (2 * index) + 1, largest = index;
        if(left < heapSize && nums[left] > nums[largest]) largest = left;
        if(right < heapSize && nums[right] > nums[largest]) largest = right;
        
        if(largest != index){
            int tmp = nums[largest];
            nums[largest] = nums[index];
            nums[index] = tmp;
            maxHeapify(nums, heapSize, largest);
        }
    }
}