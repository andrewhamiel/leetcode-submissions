class Solution {
    private Set<Integer> isTravelNeeded = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, -1);

        for(int day : days) isTravelNeeded.add(day);

        return solve(1, dp, costs);
    }

    private int solve(int day, int[] dp, int[] costs) {
        //1. Base case
        if(day >= dp.length) return 0;

        //2. Memoization
        if(dp[day] != -1) return dp[day];

        //3. If travel not needed
        if(!isTravelNeeded.contains(day)) return solve(day + 1, dp, costs);

        //4. Min cost
        int oneDay = costs[0] + solve(day + 1, dp, costs);
        int sevenDay = costs[1] + solve(day + 7, dp, costs);
        int thirtyDay = costs[2] + solve(day + 30, dp, costs);

        return dp[day] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}