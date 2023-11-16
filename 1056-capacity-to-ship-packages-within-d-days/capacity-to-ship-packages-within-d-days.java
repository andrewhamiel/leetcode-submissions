class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, total = 0;
        for(int weight : weights){
            total+= weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int left = maxWeight, right = total;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(mid, days, weights)) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private boolean isFeasible(int capacity, int days, int[] weights){
        int currWeight = 0, currDays = 1;
        for(int weight : weights){
            currWeight+= weight;
            if(currWeight > capacity){
                currDays++;
                currWeight = weight;
            }
        }
        return currDays <= days;
    }
}