class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> seen = new HashSet();
        while(j < s.length()){
            if(i == j) seen.add(s.charAt(j++));
            else if(seen.contains(s.charAt(j))){
                seen.remove(s.charAt(i++));
            }else {
                seen.add(s.charAt(j++));
            }
            max = Math.max(max, seen.size());
        }
        return max;
    }
}