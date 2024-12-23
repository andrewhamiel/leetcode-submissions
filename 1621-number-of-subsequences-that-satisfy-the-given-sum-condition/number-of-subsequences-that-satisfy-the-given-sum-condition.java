class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums); //log(n) space

        int result = 0, left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] + nums[right] > target) right--;
            else {
                result = (int)(result + quickPow(2, right - left)) % MOD;
                left++;
            }
        }
        return result;
    }

    private long quickPow(long x, int n){
        if (n == 0) return 1;

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