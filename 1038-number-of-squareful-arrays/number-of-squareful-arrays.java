class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[]{0};
        dfs(nums, 0, result);
        return result[0];
    }

    private void dfs(int[] nums, int level, int[] count){
        if(level == nums.length) count[0]++;

        for(int i = level; i < nums.length; i++){
            if(level != 0 && nums[i] == nums[level] && i != level) continue;
            if(level == 0 || isSquareful(nums[level - 1] + nums[i])){
                swap(i, level, nums);
                dfs(nums, level + 1, count);
                swap(i, level, nums);
                while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++; //move past duplicates
            } 
        }
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private boolean isSquareful(int num){
        int tmp = (int) Math.sqrt(num);
        return tmp * tmp == num;
    }
}