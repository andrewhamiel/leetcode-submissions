class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Deque<int[]> stack = new ArrayDeque<>();
        for(int[] interval : intervals) {
            if(stack.isEmpty() || stack.peekFirst()[1] < interval[0]) stack.addFirst(interval);
            else {
                int[] popped = stack.removeFirst();
                interval[0] = Math.min(interval[0], popped[0]);
                interval[1] = Math.max(interval[1], popped[1]);
                stack.addFirst(interval);
            }
        }

        int[][] result = new int[stack.size()][2];
        for(int i = result.length - 1; i >= 0; i--) result[i] = stack.removeFirst();
        return result;
    }
}