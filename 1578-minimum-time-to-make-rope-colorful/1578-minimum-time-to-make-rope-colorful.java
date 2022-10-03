class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0, currMaxTime = 0;
        
        for (int i = 0; i < colors.length(); ++i) {
            // Reset if different color
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                currMaxTime = 0;
            }  
            // Increment totalTime by the smaller one.
            // Update currMaxTime as the larger one.
            totalTime += Math.min(currMaxTime, neededTime[i]);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }
        
        return totalTime;
    }
}