class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //1. Total weight
        int max = 0, totalWeight = 0;
        for(int weight : weights){
            max = Math.max(max, weight);
            totalWeight+= weight;
        }

        //2 binary search
        int left = max, right = totalWeight;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(weights, mid, days)) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    //3 isFeasible
    private boolean isFeasible(int[] weights, int capacity, int d){
        int currentLoad = 0, daysSpent = 1;
        for(int weight : weights){
            currentLoad+= weight;
            if(currentLoad > capacity){
                daysSpent++;
                currentLoad = weight;
            }
        }
        return daysSpent <= d;
    }
}