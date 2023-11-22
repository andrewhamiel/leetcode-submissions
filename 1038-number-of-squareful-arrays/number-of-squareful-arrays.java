class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        return backtrack(0, nums);
    }

    private int backtrack(int level, int[] nums){
        if(level == nums.length) return 1;

        int count = 0;
        for(int i = level; i < nums.length; i++){
            if(i != level && nums[i] == nums[level]) continue; //keep permutations unique
            if(level == 0 || isSquareful(nums[level - 1] + nums[i])){
                swap(i, level, nums);
                count+= backtrack(level + 1, nums);
                swap(i, level, nums);
                while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++; //remove duplicates
            }
        }
        return count;
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