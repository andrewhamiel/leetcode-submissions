class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for(int weight : weights) {
            totalWeight+= weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int left = maxWeight, right = totalWeight;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(isFeasible(mid, weights, days)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean isFeasible(int capacity, int[] weights, int days) {
        int currWeight = 0, currDays = 1;
        for(int weight : weights) {
            currWeight+= weight;
            if(currWeight > capacity) {
                currWeight = weight;
                currDays++;
            }
        }
        return currDays <= days;
    }
}