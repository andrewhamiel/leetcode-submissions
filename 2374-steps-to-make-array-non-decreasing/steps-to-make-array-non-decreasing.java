class Solution {
    public int totalSteps(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(0);

        int steps = 0;
        int[] stepArr = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            int maxSteps = 0;
            while(!stack.isEmpty() && nums[i] >= nums[stack.peekFirst()]){
                maxSteps = Math.max(maxSteps, stepArr[stack.peekFirst()]);
                stack.removeFirst();
            }

            if(!stack.isEmpty() && nums[i] < nums[stack.peekFirst()]){
                stepArr[i] = maxSteps + 1;
            }

            steps = Math.max(steps, stepArr[i]);
            stack.addFirst(i);
        }
        return steps;
    }
}