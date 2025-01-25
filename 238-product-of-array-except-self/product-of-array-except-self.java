class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0, totalProduct = 1;
        for(int num : nums) {
            if(num == 0) zeroCount++;
            else totalProduct*= num;
        }

        if(zeroCount > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }

        for(int i = 0; i < nums.length; i++) {
            if(zeroCount > 0) {
                if(nums[i] == 0) nums[i] = totalProduct;
                else nums[i] = 0; 
            }else {
                nums[i] = totalProduct / nums[i];
            }
        }
        return nums;
    }
}