class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            while(stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
                int height = heights[stack.removeFirst()], width = i - stack.peekFirst() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.addFirst(i);
        }

        while(stack.peekFirst() != -1) {
            int height = heights[stack.removeFirst()], width = heights.length - stack.peekFirst() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}