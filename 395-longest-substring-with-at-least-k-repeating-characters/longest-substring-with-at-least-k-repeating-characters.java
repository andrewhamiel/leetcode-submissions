class Solution {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int maxUnique = getUniqueChars(arr), result = 0;
        for(int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            int[] freqs = new int[26];
            int left = 0, right = 0, uniqueSeen = 0, containsAtLeastK = 0;
            while(right < arr.length) {
                if(uniqueSeen <= currUnique) {
                    char c = arr[right++];
                    if(freqs[c - 'a'] == 0) uniqueSeen++;
                    freqs[c - 'a']++;
                    if(freqs[c - 'a'] == k) containsAtLeastK++;
                }else {
                    char c = arr[left++];
                    if(freqs[c - 'a'] == k) containsAtLeastK--;
                    freqs[c - 'a']--;
                    if(freqs[c - 'a'] == 0) uniqueSeen--;
                }
                //Right at next index to process
                if(uniqueSeen == currUnique && containsAtLeastK == currUnique) result = Math.max(result, right - left);
            }
        }
        return result;
    }

    private int getUniqueChars(char[] arr) {
        boolean[] seen = new boolean[26];
        int unique = 0;
        for(char c : arr) {
            if(!seen[c - 'a']) unique++;
            seen[c - 'a'] = true;
        }

        return unique;
    }
}