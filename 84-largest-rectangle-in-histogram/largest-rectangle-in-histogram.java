class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            //block on top of stack can no longer form larger rectangle
            while(stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
                int currHeight = heights[stack.removeFirst()], currWidth = i - stack.peekFirst() - 1;
                maxArea = Math.max(maxArea, currWidth * currHeight);
            }
            stack.addFirst(i);
        }

        while(stack.peekFirst() != -1) {
            int currHeight = heights[stack.removeFirst()], currWidth = heights.length - stack.peekFirst() - 1;
            maxArea = Math.max(maxArea, currWidth * currHeight);
        }
        return maxArea;
    }
}