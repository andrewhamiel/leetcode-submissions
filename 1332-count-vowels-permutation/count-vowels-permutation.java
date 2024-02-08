class Solution {
    public int countVowelPermutation(int n) {
        //base case: length is 1, equals 1
        //if length is 2, equals number of mappable characters
        //if > 2, dp[i][character]+= sum of all dp[i - 1][mappableCharacters]
        int MOD = 1_000_000_007;
        Map<Integer, List<Integer>> map = Map.of(0, List.of(1), 1, List.of(0, 2), 2, List.of(0, 1, 3, 4), 3, List.of(2, 4), 4, List.of(0));
        int[][] dp = new int[n + 1][5];
        Arrays.fill(dp[1], 1);
        if(n == 1) return 5;
        for(int i = 0; i < 5; i++) dp[2][i] = map.get(i).size();

        for(int i = 3; i <= n; i++){
            for(int vowel = 0; vowel < 5; vowel++){
                List<Integer> mappable = map.get(vowel);
                for(int nextVowel : mappable){
                    dp[i][vowel]=  (dp[i][vowel] + dp[i - 1][nextVowel]) % MOD;
                }
            }
            
        }

        int sum = 0;
        for(int i = 0; i < 5; i++) sum= (sum + dp[dp.length - 1][i]) % MOD;
        return sum;
    }
}