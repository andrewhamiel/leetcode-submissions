class Solution {
    public int longestSubstring(String s, int k) {
        //Key intuition: only 26 possible unique characters, find longest substring with each combination of unique characters
        char[] arr = s.toCharArray();
        int maxUnique = getUniqueChars(arr), longest = 0;
        for(int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            int[] freqs = new int[26];
            int left = 0, right = 0, uniqueSeen = 0, containsAtLeastK = 0;
            while(right < arr.length) {
                if(uniqueSeen <= currUnique) {
                    //Expand sliding window
                    char c = arr[right++];
                    if(freqs[c - 'a'] == 0) uniqueSeen++;
                    freqs[c - 'a']++;
                    if(freqs[c - 'a'] == k) containsAtLeastK++;
                }else {
                    //Shrink sliding window
                    char c = arr[left++];
                    if(freqs[c - 'a'] == k) containsAtLeastK--;
                    freqs[c - 'a']--;
                    if(freqs[c - 'a'] == 0) uniqueSeen--;
                }

                //Right currently at index of next char to be viewed
                if(uniqueSeen == currUnique && containsAtLeastK == currUnique) longest = Math.max(longest, right - left);
            }
        }
        return longest;
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