class Solution {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int[] freqs = new int[26];
        int maxUnique = getUniqueLetters(s), result = 0;

        for(int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            //reset freqs 
            Arrays.fill(freqs, 0);
            int left = 0, right = 0, ind = 0, unique = 0, countAtLeastK = 0;
            while(right < arr.length) {
                //Expand sliding window
                if(unique <= currUnique) {
                    char c = arr[right++];
                    if(freqs[c - 'a'] == 0) unique++;
                    freqs[c - 'a']++;
                    if(freqs[c - 'a'] == k) countAtLeastK++; 
                }else {
                    //Shrink sliding window
                    char c = arr[left++];
                    if(freqs[c - 'a'] == k) countAtLeastK--;
                    freqs[c - 'a']--;
                    if(freqs[c - 'a'] == 0) unique--;
                }
                if(unique == currUnique && unique == countAtLeastK) result = Math.max(result, right - left);
            }
        }
        return result;
    }

    private int getUniqueLetters(String s) {
        int unique = 0;
        boolean[] seen = new boolean[26];
        for(char c : s.toCharArray()) {
            if(!seen[c - 'a']) unique++;
            seen[c - 'a'] = true;
        }
        return unique;
    }
}