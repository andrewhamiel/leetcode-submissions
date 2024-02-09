class Solution {
    public int numWays(int n, int k) {
        // Base cases
        if(n == 1) return k;
        if(n == 2) return k * k;
        //After this, can not have 3 in a row, so becomes (k-1) * (dp[n-1] + dp[n-2])
        int onePost = k * k, twoPosts= k;
        for(int i = 3; i <= n; i++){
            int tmp = (k-1) * (onePost + twoPosts);
            twoPosts = onePost;
            onePost = tmp;
        }
        return onePost;
    }
}