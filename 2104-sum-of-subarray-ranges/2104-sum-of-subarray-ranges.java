class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> stack = new Stack();
        long answer = 0;
        //find sum of subarray minimums
        for(int right = 0; right <= nums.length; right++){
            while(!stack.isEmpty() && (right == nums.length || nums[stack.peek()] >= nums[right])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer-= (long) nums[mid] * (right - mid) * (mid - left);
            }
            stack.push(right);
        }
        
        stack.clear();
        //find sum of subarray maximums
        for(int right = 0; right <= nums.length; right++){
            while(!stack.isEmpty() && (right == nums.length || nums[stack.peek()] <= nums[right])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer+= (long) nums[mid] * (right - mid) * (mid - left);
            }
            stack.push(right);
        }
        return answer;
    }
}