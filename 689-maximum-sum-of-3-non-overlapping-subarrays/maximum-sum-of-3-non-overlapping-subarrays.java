class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] windows = new int[nums.length - k + 1];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
            if(i >= k) sum-= nums[i - k];
            if(i >= k - 1) windows[i - k + 1] = sum;
        }

        int[] left = new int[windows.length];
        int best = 0;
        for(int i = 0; i < left.length; i++){
            if(windows[i] > windows[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[windows.length];
        best = right.length - 1;
        for(int i = right.length - 1; i >= 0; i--){
            if(windows[i] >= windows[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1 ,-1, -1};
        int maxWindow = Integer.MIN_VALUE;
        for(int j = k; j < windows.length - k; j++){
            int l = left[j - k], r = right[j + k];
            if(maxWindow == Integer.MIN_VALUE || windows[l] + windows[j] + windows[r] > maxWindow){
                ans[0] = l;
                ans[1] = j;
                ans[2] = r;
                maxWindow = windows[l] + windows[j] + windows[r];
            }
        }
        return ans;
    }
}