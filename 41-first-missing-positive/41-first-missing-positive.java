class Solution {
    public int firstMissingPositive(int[] nums) {
        //step 1: check for 1
        boolean hasOne = false;
        for(int i = 0; i < nums.length; i++){ 
            if(nums[i] == 1){
                hasOne = true;
                break;
            }
        }
        if(!hasOne) return 1;
        //step 2: change any nums[i] <= 0 || nums[i] > nums.length to 1
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length) nums[i] = 1;
        }
        
        //step 3: change ath element to negative if present in array
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) nums[index]*=-1;
        }
        
        //step 4: return first positive index >= 1
        for(int i = 0; i < nums.length; i++) if(nums[i] > 0) return i+1;
        return nums.length+1;
    }
}