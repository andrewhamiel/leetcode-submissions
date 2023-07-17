class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles) maxPile = Math.max(maxPile, pile);

        int left = 1, right = maxPile;
        while(left < right){
            int mid = left + (right - left)/2;
            int hoursSpent = 0;
            for(int pile : piles)
                hoursSpent+= Math.ceil((double)pile/mid);
            if(hoursSpent <= h) right = mid;
            else left = mid + 1;
        }
        return right;
    }
}