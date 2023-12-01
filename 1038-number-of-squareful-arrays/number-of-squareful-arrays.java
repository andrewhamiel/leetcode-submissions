class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        return backtrack(0, nums);
    }

    private int backtrack(int level, int[] nums){
        if(level == nums.length) return 1;

        int count = 0;
        for(int i = level; i < nums.length; i++){
            if(i != level && nums[i] == nums[level]) continue; //avoid duplicates
            if(level == 0 || isSquareful(nums[level - 1] + nums[i])){
                swap(level, i, nums);
                count+= backtrack(level + 1, nums);
                swap(level, i, nums);
                while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
            }
        }
        return count;
    }

    private boolean isSquareful(int num){
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}