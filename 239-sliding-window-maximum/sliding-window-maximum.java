class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int localMax = 0;
        for(int i = 0; i < k; i++) {
            cleanDeque(i, k, nums, deq);
            deq.addLast(i);
            if(nums[i] > nums[localMax]) localMax = i;
        }    

        int[] result = new int[nums.length - k + 1];
        result[0] = nums[localMax];
        for(int i = k; i < nums.length; i++) {
            cleanDeque(i, k, nums, deq);
            deq.addLast(i);
            result[i - k + 1] = nums[deq.peekFirst()];
        }
        return result;
    }

    private void cleanDeque(int i, int k, int[] nums, Deque<Integer> deq) {
        //If window size too large
        if(!deq.isEmpty() && deq.peekFirst() == i - k) deq.removeFirst();
        //Remove nums in deq < nums[i]
        while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) deq.removeLast();
    }
}