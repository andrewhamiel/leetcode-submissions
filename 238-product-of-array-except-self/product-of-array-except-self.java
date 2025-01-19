class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1, zeroCount = 0;
        for(int num : nums) {
            if(num == 0) zeroCount++;
            else totalProduct*= num;
        }

        for(int i = 0; i < nums.length; i++) {
            if(zeroCount > 0) nums[i] = nums[i] != 0 || zeroCount > 1 ? 0 : totalProduct;
            else nums[i] = totalProduct / nums[i];
        }
        return nums;
    }
}