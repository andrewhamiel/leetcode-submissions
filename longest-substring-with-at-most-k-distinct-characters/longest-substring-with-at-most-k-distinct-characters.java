class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, max = 0;
        for(int right = 0; right < s.length(); right++){
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);
            while(freq.size() > k){
                freq.put(s.charAt(left), freq.getOrDefault(s.charAt(left), 1) - 1);
                if(freq.get(s.charAt(left)) == 0) freq.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}