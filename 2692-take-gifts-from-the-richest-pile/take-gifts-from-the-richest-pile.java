class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long totalGifts = 0;
        for(int gift : gifts) {
            maxHeap.add((long) gift);
            totalGifts+= gift;
        }

        long removedGifts = 0;
        for(int i = 0; i < k; i++) {
            long maxPile = maxHeap.poll();
            int reducedPile = (int) Math.floor(Math.sqrt(maxPile));
            removedGifts+= maxPile - reducedPile;
            maxHeap.add((long)reducedPile);
        }
        return totalGifts - removedGifts;
    }
}