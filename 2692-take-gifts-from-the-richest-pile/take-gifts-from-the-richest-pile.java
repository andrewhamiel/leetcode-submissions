class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalGifts = 0;
        for(int gift : gifts) {
            totalGifts+= gift;
            maxHeap.add(gift);
        }

        long removedGifts = 0;
        for(int i = k; i > 0; i--) {
            int giftToBeRemoved = maxHeap.poll();
            int reducedPile = sqrt(giftToBeRemoved);
            removedGifts+= giftToBeRemoved - reducedPile;
            maxHeap.add(reducedPile);
        }
        return totalGifts - removedGifts;
    }

    private int sqrt(int num) {
        if(num < 2) return 1;
        int left = 2, right = num / 2;
        while(left <= right) {
            int mid = left + (right - left)/2;
            long pow = (long) mid * mid;
            if(pow == num) return mid;
            else if(pow < num) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
}