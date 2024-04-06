class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(Math.abs(target - sum) < Math.abs(minDiff)) minDiff = target - sum;
                else if(sum < target) left++;
                else right--;
            }
        }
        return target - minDiff;
    }
}