class Solution {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(heights.length - 1);
        for(int i = heights.length - 2; i >= 0; i--) {
            if(heights[i] > heights[stack.peekFirst()]) stack.addFirst(i);
        }
        
        int[] result = new int[stack.size()];
        for(int i = 0; i < result.length; i++) result[i] = stack.removeFirst();
        return result;
    }
}