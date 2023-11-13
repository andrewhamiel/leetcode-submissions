class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num : nums) seen.add(num);

        int longestStreak = 0;
        for(int num : seen){
            if(!seen.contains(num - 1)){
                int currentNum = num, currentStreak = 1;
                while(seen.contains(currentNum+1)){
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}