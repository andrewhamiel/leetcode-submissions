class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minLeft = 0, minRight = Integer.MAX_VALUE, maxSeen = Integer.MIN_VALUE;
        int[] next = new int[nums.size()]; //store next columns
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> nums.get(a).get(next[a]) - nums.get(b).get(next[b]));

        for(int i = 0; i < nums.size(); i++){
            minHeap.add(i);
            maxSeen = Math.max(maxSeen, nums.get(i).get(next[i]));
        }

        for(int row = 0; row < nums.size(); row++){
            for(int col = 0; col < nums.get(row).size(); col++){
                int rowWithLowestNext = minHeap.poll();
                int lowestNext = nums.get(rowWithLowestNext).get(next[rowWithLowestNext]);
                if(minRight - minLeft > maxSeen - lowestNext) {
                    minLeft = lowestNext;
                    minRight = maxSeen;
                }

                next[rowWithLowestNext]++;
                if(next[rowWithLowestNext] == nums.get(rowWithLowestNext).size()){
                    return new int[]{minLeft, minRight};
                }

                int nextValAfterIncrement = nums.get(rowWithLowestNext).get(next[rowWithLowestNext]);
                minHeap.add(rowWithLowestNext);
                maxSeen = Math.max(maxSeen, nextValAfterIncrement);
            }
        }
        return new int[]{minLeft, minRight};
    }
}