class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] windows = new int[nums.length - k + 1];
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            currSum+= nums[i];
            if(i >= k) currSum-= nums[i - k];
            if(i >= k - 1) windows[i - k + 1] = currSum;
        }

        int[] left = new int[windows.length];
        int best = 0;
        for(int i = 0; i < left.length; i++){
            if(windows[i] > windows[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[windows.length];
        best = windows.length - 1;
        for(int i = right.length - 1; i >= 0; i--){
            if(windows[i] >= windows[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        for(int j = k; j < windows.length - k; j++){
            int l = left[j - k], r = right[j + k];
            if(ans[0] == -1 || windows[l] + windows[j] + windows[r] > windows[ans[0]] + windows[ans[1]] + windows[ans[2]]){
                ans[0] = l;
                ans[1] = j;
                ans[2] = r;
            }
        }
        return ans;
    }
}