class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles) maxPile = Math.max(maxPile, pile);

        int left = 1, right = maxPile;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isFeasible(piles, h, mid)) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    private boolean isFeasible(int[] piles, int h, int capacity){
        int hours = 0;
        for(int bananas : piles){
            hours+= (bananas/capacity);
            int rem = bananas % capacity;
            if(rem > 0) hours++;
        }
        return hours <= h;
    }
}