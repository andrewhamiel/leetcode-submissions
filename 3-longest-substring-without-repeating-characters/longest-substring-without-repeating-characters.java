class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right = 0, result = 0;
        while(right < s.length()) {
            char c = s.charAt(right);
            if(seen.contains(c)) seen.remove(s.charAt(left++));
            else seen.add(s.charAt(right++));
            result = Math.max(result, right - left);
        }
        return result;
    }
}