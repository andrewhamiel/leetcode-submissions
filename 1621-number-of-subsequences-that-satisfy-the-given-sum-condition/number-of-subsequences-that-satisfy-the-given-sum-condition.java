class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        //1. Sort
        Arrays.sort(nums);    

        //2. 2P and Binary Exp
        int left = 0, right = nums.length - 1, result = 0;
        while(left <= right) {
            if(nums[left] + nums[right] > target) right--;
            else {
                //All subsequences in range [left, right] have 2 choices: include or not include
                //Total subsequences is 2^(right - left)
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