class Solution {
    public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(heights.length - 1);
        int maxHeight = heights[heights.length - 1];
        for(int i = heights.length - 2; i >= 0; i--){
            if(heights[i] > maxHeight){
                stack.addFirst(i);
                maxHeight = heights[i];
            } 
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i++) ans[i] = stack.removeFirst();
        return ans;
    }
}