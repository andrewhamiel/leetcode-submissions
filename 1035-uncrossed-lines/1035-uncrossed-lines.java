class Solution {
    int[][] memo;
    int[] nums1, nums2;
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        memo = new int[nums1.length][nums2.length];
        
        for(int[] row : memo) Arrays.fill(row, -1);
        return dp(0, 0);
    }
    
    private int dp(int p1, int p2){
        if(p1 >= nums1.length || p2 >= nums2.length) return 0;
        if(memo[p1][p2] != -1) return memo[p1][p2];
        
        //Case 2: Not equal
        int option1 = Math.max(dp(p1+1, p2), dp(p1, p2+1));
        if(nums1[p1] == nums2[p2]) option1 = Math.max(option1, 1 + dp(p1 + 1, p2 + 1));
        memo[p1][p2] = option1;
        return memo[p1][p2];
    }
}