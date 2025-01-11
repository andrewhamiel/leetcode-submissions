class Solution {
    private int[] nums;
    private Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        //Reservoir Sampling
        int count = 0, ind = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                count++;
                if(rand.nextInt(count) == 0) ind = i;
            }
        }
        return ind;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */