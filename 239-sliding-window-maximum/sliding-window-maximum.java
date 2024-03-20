class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int localMax = 0;
        for(int i = 0; i < k; i++){
            cleanDeque(i, k, nums, deq);
            deq.addLast(i);
            if(nums[i] > nums[localMax]) localMax = i;
        }

        int[] answer = new int[nums.length - k + 1];
        answer[0] = nums[localMax];
        for(int i = k; i < nums.length; i++){
            cleanDeque(i, k, nums, deq);
            deq.addLast(i);
            answer[i - k + 1] = nums[deq.peekFirst()];
        }
        return answer;
    }

    private void cleanDeque(int i, int k, int[] nums, Deque<Integer> deq){
        //If window size too large
        if(!deq.isEmpty() && deq.peekFirst() == i - k) deq.removeFirst();
        //Remove numbers from deq < curr
        while(!deq.isEmpty() && nums[i] > nums[deq.peekLast()]) deq.removeLast();
    }
}