class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0;

        for(int i = 0; i < 32; i++) {
            int mask = 1 << i;

            int bitCount = 0;
            for(int num : nums) {
                if((num & mask) != 0) bitCount++;
            }
            if(bitCount > nums.length / 2) majorityElement |= mask;
        }
        return majorityElement;
    }
}