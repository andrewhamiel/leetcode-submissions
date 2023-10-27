
class Solution {
    public int numSquarefulPerms(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[]{0};
        dfs(nums, 0, res);
        return res[0];
    }
    public void dfs(int[] nums, int level, int[] count) {
        int n = nums.length;
        if(level == nums.length){
            count[0]++;
        }
        if(level == 0) {
            for(int i = 0; i<n; i++) {
                swap(nums, level, i);
                dfs(nums,level+1, count);
                swap(nums, i, level);
                while(i+1<n && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        } else {
            for(int i = level; i<n; i++) {
                if(nums[i] == nums[level] && i!= level) {
                    continue;
                }
                if(isSquareful(nums[level-1] + nums[i])) {                    
                    swap(nums, level, i);               
                    dfs(nums,level+1, count);
                    swap(nums, i, level);                   
                }
                while(i+1<n && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
    }
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    private boolean isSquareful(int num){
        int temp = (int)Math.sqrt(num);
        if(temp * temp == num) {
            return true;
        }
        return false;
    }
    private int factorial(int dup) {
        if(dup ==1 || dup == 2) {
            return dup;
        }
        return dup * factorial(dup-1);
    }
}