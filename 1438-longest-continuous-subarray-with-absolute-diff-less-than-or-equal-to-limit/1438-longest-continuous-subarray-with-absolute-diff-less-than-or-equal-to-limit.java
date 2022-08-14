class Solution {
    public int longestSubarray(int[] nums, int limit) {      
        Deque<Integer> increasing = new ArrayDeque(), decreasing = new ArrayDeque(); 
        int i = 0, j = 0, max_length = 0;
        
        while(j < nums.length){
            while(!increasing.isEmpty() && nums[increasing.peekLast()] >= nums[j])
                increasing.pollLast();
            increasing.add(j);
            
            while(!decreasing.isEmpty() && nums[decreasing.peekLast()] <= nums[j])
                decreasing.pollLast();
            decreasing.add(j);
            
            int max_val = nums[decreasing.peekFirst()], min_val = nums[increasing.peekFirst()];
            
            if(max_val-min_val <= limit) max_length = Math.max(max_length, j-i+1);
            else{ 
                // If maximum absolute diff > limit , then remove from dequeue and increase i
                while(i<=j  && nums[decreasing.peekFirst()] - nums[increasing.peekFirst()] > limit ){   
                    if(!increasing.isEmpty() && increasing.peekFirst() == i) increasing.pollFirst();
                
                    if(!decreasing.isEmpty() && decreasing.peekFirst() == i) decreasing.pollFirst();
                    i++ ; 
                }                                       
            }        
            j++ ;
        } 
        return max_length ;
    }
}