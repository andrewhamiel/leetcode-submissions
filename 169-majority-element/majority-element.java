class Solution {
    public int majorityElement(int[] nums) {
        int candidate = Integer.MAX_VALUE, count = 0;
        for(int num : nums) {
            if(count == 0) candidate = num;

            if(num == candidate) count++;
            else count--;
        }
        return candidate;
    }
}