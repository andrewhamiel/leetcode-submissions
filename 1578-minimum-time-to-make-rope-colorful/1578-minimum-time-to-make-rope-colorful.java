class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0, currMax = neededTime[0];
        for(int i = 1; i < neededTime.length; i++){
            if(colors.charAt(i) != colors.charAt(i-1)) currMax = 0;
            
            totalTime += Math.min(currMax, neededTime[i]);
            currMax = Math.max(currMax, neededTime[i]);
        }
        return totalTime;
    }
}