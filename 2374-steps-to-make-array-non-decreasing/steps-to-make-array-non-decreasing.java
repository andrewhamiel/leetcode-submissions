class Solution {
    public int totalSteps(int[] nums) {
        Stack stack = new Stack<Integer>();
        stack.push(0);
        int steps=0;
        int[] step_arr = new int[nums.length]; 
        for(int i=1;i<nums.length;i++){
            int max_steps = 0;
            while(!stack.empty() && nums[i]>=nums[(Integer)stack.peek()]){
                max_steps=Math.max(max_steps,step_arr[(Integer)stack.peek()]);
                stack.pop();
            }
            if(!stack.empty() && nums[i]<nums[(Integer)stack.peek()]){
                    step_arr[i]=1+max_steps;
            }
            steps = Math.max(steps,step_arr[i]);
            stack.push(i);
        }
        return steps;
    }
}