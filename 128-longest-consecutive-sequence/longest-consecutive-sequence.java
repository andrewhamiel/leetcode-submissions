class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) seen.add(num);

        int longestStreak = 0;
        for(int num : seen){
            if(!seen.contains(num - 1)){
                int currNum = num, currStreak = 1;
                while(seen.contains(currNum + 1)){
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}