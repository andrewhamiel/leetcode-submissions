class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2 && min != 0; i++){
            int left = i+1, right = nums.length - 1;
            while(left >= 0 && left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-sum) < Math.abs(min)) min = target-sum;
                
                if(sum < target) left++;
                else right--;
            }
        }
        return target-min;
    }
}