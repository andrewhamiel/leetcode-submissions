class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minLeft = 0, minRight = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] next = new int[nums.size()]; //Column we should be viewing
        boolean reachedEndOfList = false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> nums.get(a).get(next[a]) - nums.get(b).get(next[b]));
        for(int i = 0; i < nums.size(); i++){
            minHeap.add(i);
            max = Math.max(max, nums.get(i).get(next[i]));
        }

        for(int row = 0; row < nums.size() && !reachedEndOfList; row++){
            for(int col = 0; col < nums.get(row).size() && !reachedEndOfList; col++){
                int rowWithLowestNext = minHeap.poll();
                int lowestNext = nums.get(rowWithLowestNext).get(next[rowWithLowestNext]);
                if(minRight - minLeft > max - lowestNext){
                    minLeft = lowestNext;
                    minRight = max;
                }
                next[rowWithLowestNext]++;
                if(next[rowWithLowestNext] == nums.get(rowWithLowestNext).size()){
                    reachedEndOfList = true;
                    break;
                }
                minHeap.add(rowWithLowestNext);
                lowestNext = nums.get(rowWithLowestNext).get(next[rowWithLowestNext]); //reset
                max = Math.max(max, lowestNext);
            }
        }
        return new int[]{minLeft, minRight};
    }
}