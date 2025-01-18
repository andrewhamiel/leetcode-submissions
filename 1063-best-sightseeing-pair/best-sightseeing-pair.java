class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int bestLeftScore = values[0], result = 0;
        for(int i = 1; i < values.length; i++) {
            int currRightScore = values[i] - i;
            result = Math.max(result, bestLeftScore + currRightScore);
            bestLeftScore = Math.max(bestLeftScore, values[i] + i);
        }
        return result;
    }
}