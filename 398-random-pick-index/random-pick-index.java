class Solution {
    private int[] nums;
    private Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0, result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
                if(rand.nextInt(count) == 0) result = i; 
            }
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */