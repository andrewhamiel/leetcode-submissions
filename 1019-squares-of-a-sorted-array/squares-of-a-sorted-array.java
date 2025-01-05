class Solution {
    public int[] sortedSquares(int[] nums) {
        //Key intuition: array is sorted. Largest powers would be farthest left and farthest right because -num * -num = num^2
        int[] result = new int[nums.length];
        //2P 
        int left = 0, right = nums.length - 1;
        for(int k = nums.length - 1; k >= 0; k--) {
            int powLeft = nums[left] * nums[left];
            int powRight = nums[right] * nums[right];
            if(powLeft >= powRight) {
                result[k] = powLeft;
                left++;
            }else {
                result[k] = powRight;
                right--;
            }
        }
        return result;
    }
}