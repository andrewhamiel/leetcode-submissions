class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        //1. Sort. Maintain relative position
        Arrays.sort(nums);
        //2. 2P and Binary Exp
        int left = 0, right = nums.length - 1, result = 0;
        //[left, right] variant
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[left] + nums[right] > target) right--;
            else {
                result = (result + (int) binaryExp(2, right - left)) % MOD;
                left++;
            }
        }
        return result;
    }

    private long binaryExp(long x, int n) {
        if(n == 0) return 1;

        long result = 1;
        while(n != 0) {
            if(n % 2 != 0) {
                result = (result * x) % MOD;
                n--;
            }
            x = (x * x) % MOD;
            n/= 2;
        }
        return result % MOD;
    }
}