class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, longest = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(!seen.contains(c)) seen.add(s.charAt(right++));
            else seen.remove(s.charAt(left++));
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}