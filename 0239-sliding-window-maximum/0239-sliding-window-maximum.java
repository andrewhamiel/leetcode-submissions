class Solution {
    private ArrayDeque<Integer> deq = new ArrayDeque();
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        //first sliding window
        int localMax = 0;
        for(int i = 0; i < k; i++){
            cleanDeque(i, k, nums);
            deq.add(i);
            if(nums[i] > nums[localMax]) localMax = i;
        }
        
        int[] answer = new int[nums.length - k + 1];
        answer[0] = nums[localMax];
        for(int i = k; i < nums.length; i++){
            cleanDeque(i, k, nums);
            deq.add(i);
            answer[i-k+1] = nums[deq.peek()];
        }
        return answer;
    }
    
    private void cleanDeque(int i, int k, int[] nums){
        if(!deq.isEmpty() && deq.peek() == i - k) deq.pop();
        while(!deq.isEmpty() && nums[i] > nums[deq.peekLast()]) deq.removeLast();
    }
}