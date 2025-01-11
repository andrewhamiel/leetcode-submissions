class Solution {
    public int longestSubstring(String s, int k) {
        int maxUnique = getUniqueChars(s), result = 0;
        //Sliding window
        for(int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            int[] freqs = new int[26];
            int left = 0, right = 0, uniqueSeen = 0, containsAtLeastK = 0;
            while(right < s.length()) {
                if(uniqueSeen <= currUnique) {
                    char c = s.charAt(right++);
                    if(freqs[c - 'a'] == 0) uniqueSeen++;
                    freqs[c - 'a']++;
                    if(freqs[c - 'a'] == k) containsAtLeastK++;
                }else {
                    char c = s.charAt(left++);
                    if(freqs[c - 'a'] == k) containsAtLeastK--;
                    freqs[c - 'a']--;
                    if(freqs[c - 'a'] == 0) uniqueSeen--;
                }

                //Right at next index to be evaluated
                if(uniqueSeen == currUnique && containsAtLeastK == currUnique) result = Math.max(result, right - left);
            }
        }
        return result;
    }

    private int getUniqueChars(String s) {
        int unique = 0;
        boolean[] seen = new boolean[26];
        for(char c : s.toCharArray()) {
            if(!seen[c - 'a']) unique++;
            seen[c - 'a'] = true; 
        }
        return unique;
    }
}