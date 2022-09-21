class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for(int num : nums) if(num % 2 == 0) sum+=num;
        
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int value = queries[i][0], index = queries[i][1];
            if(nums[index] % 2 == 0) sum-=nums[index];
            nums[index]+=value;
            if(nums[index] % 2 == 0) sum+=nums[index];
            ans[i] = sum;
        }
        return ans;
    }
}