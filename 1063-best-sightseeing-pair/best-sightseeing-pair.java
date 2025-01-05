class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //Key intuition: for each pair, left -> values[i] + i, right -> values[j] - j
        int maxLeftScore = values[0], result = 0;
        for(int i = 1; i < values.length; i++) {
            int currRightScore = values[i] - i;
            result = Math.max(result, maxLeftScore + currRightScore);
            maxLeftScore = Math.max(maxLeftScore, values[i] + i);
        }
        return result;
    }
}