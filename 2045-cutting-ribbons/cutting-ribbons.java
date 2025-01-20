class Solution {
    public int maxLength(int[] ribbons, int k) {
        int maxRibbonLength = 0;
        for(int ribbon : ribbons) {
            maxRibbonLength = Math.max(maxRibbonLength, ribbon);
        }

        int left = 1, right = maxRibbonLength + 1;
        //[left, right) variant
        while(left < right) {
            int mid = left + (right - left)/2;

            if(!isFeasible(mid, ribbons, k)) right = mid;
            else left = mid + 1;
        }
        return left - 1;
    }

    private boolean isFeasible(int capacity, int[] ribbons, int k) {
        int currSegments = 0;
        for(int ribbon : ribbons) {
            currSegments+= ribbon / capacity;
        }
        return currSegments >= k;
    }
}