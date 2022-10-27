public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int length = heights.length, maxArea = 0;
        stack.push(-1);
        for(int i = 0; i < heights.length; i++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int currHeight = heights[stack.pop()], currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            stack.push(i);
        }
        
        while(stack.peek() != -1){
            int currHeight = heights[stack.pop()], currWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }
        return maxArea;
    }
}