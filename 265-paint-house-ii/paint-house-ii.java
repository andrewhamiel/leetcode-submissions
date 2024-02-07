class Solution {
    public int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        for(int[] row : dp) Arrays.fill(row, -1);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < costs[0].length; i++){
            min = Math.min(min, dp(costs, dp, 0, i));
        }
        return min;
    }

    private int dp(int[][] costs, int[][] dp, int house, int color){
        if(house >= costs.length || color >= costs[0].length) return Integer.MAX_VALUE;

        if(dp[house][color] != -1) return dp[house][color];

        if(house == costs.length - 1) return costs[house][color];

        int cost = costs[house][color];
        int additionalCost = Integer.MAX_VALUE;
        for(int i = 0; i < costs[0].length; i++){
            if(i != color){
                additionalCost = Math.min(additionalCost, dp(costs, dp, house + 1, i));
            }
        }
        return dp[house][color] = cost + additionalCost;
    }
}