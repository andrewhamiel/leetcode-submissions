public class Solution {
    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int[] freqs = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            Arrays.fill(freqs, 0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < arr.length) {
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = arr[windowEnd] - 'a';
                    if (freqs[idx] == 0) unique++;
                    freqs[idx]++;
                    if (freqs[idx] == k) countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = arr[windowStart] - 'a';
                    if (freqs[idx] == k) countAtLeastK--;
                    freqs[idx]--;
                    if (freqs[idx] == 0) unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    result = Math.max(windowEnd - windowStart, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean seen[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!seen[s.charAt(i) - 'a'])  maxUnique++;
            seen[s.charAt(i) - 'a'] = true;
        }
        return maxUnique;
    }
}
