class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //Intuition: left -> values[i] + i
        //Right -> values[i] - i
        int maxLeftScore = values[0] + 0, result = 0;
        
        for(int i = 1; i < values.length; i++){
            int currRightScore = values[i] - i;
            result = Math.max(result, maxLeftScore + currRightScore);
            maxLeftScore = Math.max(maxLeftScore, values[i] + i);
        }
        return result;
    }
}