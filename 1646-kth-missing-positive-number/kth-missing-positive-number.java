class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(missingNums(arr.length - 1, arr) < k) return arr[arr.length - 1] + k - missingNums(arr.length - 1, arr);

        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(missingNums(mid, arr) < k) left = mid + 1;
            else right = mid - 1;
        }

        //nums[right] + k - missingNums(right, arr)
        //nums[right] + k - nums[right] + right + 1
        //k + right + 1
        //k + left
        return k + left;
    }

    private int missingNums(int ind, int[] nums) {
        return nums[ind] - ind - 1; //1 is first num
    }
}