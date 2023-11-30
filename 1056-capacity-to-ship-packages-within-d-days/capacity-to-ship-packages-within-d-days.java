class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for(int weight : weights){
            maxWeight = Math.max(maxWeight, weight);
            totalWeight+= weight;
        }

        int left = maxWeight, right = totalWeight;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(mid, days, weights)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean isFeasible(int capacity, int days, int[] weights){
        int currWeight = 0, currDays = 1;
        for(int weight : weights){
            currWeight+= weight;
            if(currWeight > capacity){
                currWeight = weight;
                currDays++;
            }
        }
        return currDays <= days;
    }
}