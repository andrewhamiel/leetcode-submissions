class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(0, nums.length - 1, nums, k - 1);
    }

    private int quickselect(int left, int right, int[] nums, int k) {
        if(left >= right) return nums[left];

        int pivotInd = new Random().nextInt(right - left) + left;
        pivotInd = partition(left, right, nums, pivotInd);
        if(pivotInd == k) return nums[k];
        else if(pivotInd < k) {
            pivotInd++;
            while(pivotInd < k && nums[pivotInd] == nums[pivotInd - 1]) pivotInd++; //Avoid duplicates
            return quickselect(pivotInd, right, nums, k);
        }else {
            pivotInd--;
            while(pivotInd > k && nums[pivotInd] == nums[pivotInd + 1]) pivotInd--;
            return quickselect(left, pivotInd, nums, k);
        }
    }

    private int partition(int left, int right, int[] nums, int pivotInd) {
        int pivotValue = nums[pivotInd];
        swap(pivotInd, right, nums);
        int swapInd = left;
        for(int i = left; i <= right; i++) {
            if(nums[i] > pivotValue) swap(swapInd++, i, nums);
        }
        swap(swapInd, right, nums);
        return swapInd;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}