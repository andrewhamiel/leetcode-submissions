class Solution {
    public int totalSteps(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(0);

        int result = 0;
        int[] stepsArr = new int[nums.length];
        for(int i = 1; i < nums.length; i++){
            int maxSteps = 0;
            while(!stack.isEmpty() && nums[i] >= nums[stack.peekFirst()]){
                maxSteps = Math.max(maxSteps, stepsArr[stack.peekFirst()]);
                stack.removeFirst();
            }

            if(!stack.isEmpty() && nums[i] < nums[stack.peekFirst()]){
                stepsArr[i] = maxSteps + 1;
            }

            result = Math.max(result, stepsArr[i]);
            stack.addFirst(i);
        }
        return result;
    }
}