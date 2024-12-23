class Solution {
    private Set<Integer> isTravelNeeded = new HashSet<>();

    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];

        Arrays.fill(dp, -1);
        for(int day : days) isTravelNeeded.add(day);
        return solve(days, costs, dp, 1);
    }

    private int solve(int[] days, int[] costs, int[] dp, int day) {
        if(day > days[days.length - 1]) return 0;

        if(dp[day] != -1) return dp[day];

        if(!isTravelNeeded.contains(day)) return solve(days, costs, dp, day + 1);

        int oneDay = costs[0] + solve(days, costs, dp, day + 1);
        int sevenDay = costs[1] + solve(days, costs, dp, day + 7);
        int thirtyDay = costs[2] + solve(days, costs, dp, day + 30);

        return dp[day] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
    }
}