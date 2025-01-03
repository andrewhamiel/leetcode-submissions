class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, longest = 0;
        while(right < s.length()) {
            if(seen.contains(s.charAt(right))) seen.remove(s.charAt(left++));
            else seen.add(s.charAt(right++));
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}