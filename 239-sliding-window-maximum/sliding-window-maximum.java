class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
        int localMax = 0;
        for(int i = 0; i < k; i++) {
            cleanDeque(i, nums, deq, k);
            deq.addLast(i);
            if(nums[i] > nums[localMax]) localMax = i;
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = nums[localMax];
        for(int i = k; i < nums.length; i++) {
            cleanDeque(i, nums, deq, k);
            deq.addLast(i);
            result[i - k + 1] = nums[deq.peekFirst()];
        }
        return result;
    }

    private void cleanDeque(int i, int[] nums, Deque<Integer> deq, int k) {
        //If number out of window
        if(!deq.isEmpty() && deq.peekFirst() == i - k) deq.removeFirst();
        //Remove nums in deq < nums[i]
        while(!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) deq.removeLast();
    }
}