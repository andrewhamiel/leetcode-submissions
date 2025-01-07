class Solution {
    Set<Integer> isTravelNeeded = new HashSet<>();
    private int[] costs;
    private int[] dp;

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        dp = new int[lastDay + 1];
        Arrays.fill(dp, -1);

        for(int day : days) isTravelNeeded.add(day);

        this.costs = costs;

        return solve(1);
    }

    private int solve(int day) {
        //1. Exit condition
        if(day >= dp.length) return 0;

        //2. Memoization
        if(dp[day] != -1) return dp[day];

        //3. If travel is not needed
        if(!isTravelNeeded.contains(day)) return solve(day + 1);

        //4. Min cost
        int oneDay = costs[0] + solve(day + 1);
        int sevenDay = costs[1] + solve(day + 7);
        int thirtyDay = costs[2] + solve(day + 30);

        return dp[day] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}