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

    private boolean isFeasible(int[] piles, int hours, int capacity){
        int h = 0;
        for(int pile : piles){
            h+= (pile/capacity);
            int rem = pile % capacity;
            if(rem > 0) h++;
        }
        return h <= hours;
    }
}