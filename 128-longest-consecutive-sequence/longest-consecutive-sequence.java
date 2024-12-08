class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) seen.add(num);

        int longestSequence = 0;
        for(int num : nums) {
            if(!seen.contains(num - 1)) {
                int currSequence = 0, currNum = num;
                while(seen.contains(currNum)) {
                    currSequence++;
                    currNum++;
                }
                longestSequence = Math.max(longestSequence, currSequence);
            }
        }
        return longestSequence;
    }
}