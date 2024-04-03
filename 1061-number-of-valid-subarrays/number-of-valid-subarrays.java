class Solution {
    public int validSubarrays(int[] nums) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && nums[i] < nums[stack.peekFirst()]){
                answer+= (i - stack.removeFirst());
            }
            stack.addFirst(i);
        }

        while(!stack.isEmpty()){
            answer+= (nums.length - stack.removeFirst());
        }
        return answer;
    }
}