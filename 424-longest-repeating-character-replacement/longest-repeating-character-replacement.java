class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 0) return 1;
        int[] count = new int[26];

        int left = 0, maxCount = 0, result = 0;
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            count[c - 'A']++;
            maxCount = Math.max(maxCount, count[c - 'A']);
            if(right - left + 1 - maxCount > k){
                count[s.charAt(left++) - 'A']--;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}