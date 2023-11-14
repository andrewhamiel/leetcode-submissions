class Solution {
    public int change(int amount, int[] coins) {
        int[] sums = new int[amount + 1];
        sums[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++) sums[i]+= sums[i-coin];
        }
        return sums[amount];
    }
}