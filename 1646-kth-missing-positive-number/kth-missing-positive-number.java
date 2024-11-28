class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(missingNums(arr.length - 1, arr) < k) return arr[arr.length - 1] + k - missingNums(arr.length - 1, arr);

        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(missingNums(mid, arr) < k) left = mid + 1;
            else right = mid - 1; 
        }

        //arr[right] + k - missingNums(right, arr)
        //arr[right] + k - arr[right] + right + 1
        //k + right + 1
        //k + left
        return k + left;
    }

    private int missingNums(int ind, int[] nums) {
        return nums[ind] - ind - 1; //First num is 0
    }
}