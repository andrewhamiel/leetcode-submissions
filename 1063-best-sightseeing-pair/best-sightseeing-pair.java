class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //Key insight: For each pair, Left -> values[i] + i, Right -> values[j] - j
        int maxLeftScore = values[0], result = 0;
        for(int i = 1; i < values.length; i++) {
            int currRightScore = values[i] - i; //Right -> values[j] - j        
            result = Math.max(result, maxLeftScore + currRightScore); 
            maxLeftScore = Math.max(maxLeftScore, values[i] + i); //Left -> values[i] + i
        }
        return result;
    }
}