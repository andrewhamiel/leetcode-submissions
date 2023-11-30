class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(k > missingNums(arr, arr.length - 1)) return arr[arr.length - 1] + k - missingNums(arr, arr.length - 1);

        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(missingNums(arr, mid) < k) left = mid + 1;
            else right = mid - 1;
        }
        //left == right + 1
        //kth missing number is arr[right] + k - missingNums(arr, right)
        //-> arr[right] + k - (arr[right] - 1 - right)
        //-> k + 1 + right
        //-> k + left
        return k + left;
    }

    private int missingNums(int[] nums, int ind){
        return nums[ind] - 1 - ind; //1 is first positive number
    }
}