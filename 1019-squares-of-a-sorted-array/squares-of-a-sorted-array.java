class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for(int i = result.length - 1; i >= 0; i--) {
            int powA = nums[left] * nums[left];
            int powB = nums[right] * nums[right];
            if(powA >= powB) {
                result[i] = powA;
                left++;
            }else {
                result[i] = powB;
                right--;
            }
        }
        return result;
    }
}