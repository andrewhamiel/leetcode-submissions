class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> subArr = new ArrayList<>();
        subArr.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > subArr.get(subArr.size() - 1)) subArr.add(nums[i]);
            else{
                int j = 0;
                while(subArr.get(j) < nums[i]) j++;
                subArr.set(j, nums[i]);
            }
        }
        return subArr.size();
    }
}