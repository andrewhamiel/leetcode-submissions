class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(k > missingNums(arr, arr.length - 1)) return arr[arr.length - 1] + k - missingNums(arr, arr.length - 1);
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(missingNums(arr, mid) < k) left = mid + 1;
            else right = mid - 1;
        }
        return left + k;
    }

    private int missingNums(int[] nums, int ind){
        return nums[ind] - 1 - ind; // 1 is first positive number
    }
}