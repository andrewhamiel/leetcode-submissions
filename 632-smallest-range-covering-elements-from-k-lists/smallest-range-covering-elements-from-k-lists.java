class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minLeft = 0, minRight = Integer.MAX_VALUE, maxSeen = Integer.MIN_VALUE;
        int[] nextCol = new int[nums.size()];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> nums.get(a).get(nextCol[a]) - nums.get(b).get(nextCol[b]));

        for(int row = 0; row < nums.size(); row++){
            minHeap.add(row);
            maxSeen = Math.max(maxSeen, nums.get(row).get(nextCol[row]));
        }

        for(int row = 0; row < nums.size(); row++){
            for(int col = 0; col < nums.get(row).size(); col++){
                int rowWithLowestNext = minHeap.poll();
                int lowestNext = nums.get(rowWithLowestNext).get(nextCol[rowWithLowestNext]);
                if(minRight - minLeft > maxSeen - lowestNext) {
                    minLeft = lowestNext;
                    minRight = maxSeen;
                }

                nextCol[rowWithLowestNext]++;
                if(nextCol[rowWithLowestNext] == nums.get(rowWithLowestNext).size()){
                    return new int[]{minLeft, minRight};
                }

                int nextValAtRow = nums.get(rowWithLowestNext).get(nextCol[rowWithLowestNext]);
                minHeap.add(rowWithLowestNext);
                maxSeen = Math.max(maxSeen, nextValAtRow);
            }
        }
        return new int[]{minLeft, minRight};
    }
}