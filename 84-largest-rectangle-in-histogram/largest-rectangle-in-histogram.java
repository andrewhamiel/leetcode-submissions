class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        int length = heights.length, maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            while(stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
                int currHeight = heights[stack.removeFirst()], currWidth = i - stack.peekFirst() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.addFirst(i);
        }

        while(stack.peekFirst() != -1) {
            int currHeight = heights[stack.removeFirst()], currWidth = length - stack.peekFirst() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }
        return maxArea;
    }
}