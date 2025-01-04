class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Voting algorithm
        int count = 0, candidate = 0;
        for(int num : nums) {
            if(count == 0) candidate = num;
            count+= num == candidate ? 1 : -1;
        }
        return candidate;
    }
}