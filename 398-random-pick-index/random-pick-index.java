class Solution {
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0, index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                count++;
                if(rand.nextInt(count) == 0) index = i;
            }
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */