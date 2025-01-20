class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int left = 1, right = maxPile;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(isFeasible(mid, piles, h)) right = mid;
            else left = mid + 1; 
        }
        return right;
    }

    private boolean isFeasible(int capacity, int[] piles, int h) {
        int currHours = 0;
        for(int bananas : piles) {
            currHours+= bananas / capacity;
            if(bananas % capacity > 0) currHours++;
        }
        return currHours <= h;
    }
}