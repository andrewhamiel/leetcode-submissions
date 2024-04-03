class Solution {
    public int validSubarrays(int[] nums) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[i] < nums[stack.peekFirst()]){
                result+= (i - stack.removeFirst());
            }
            stack.addFirst(i);
        }

        while(!stack.isEmpty()){
            result+= (nums.length - stack.removeFirst());
        }
        return result;
    }
}