class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int left = 0; int right = 0;
        int result = 0;
        while (right < s.length()) {
            char ch=s.charAt(right);
            count[ch-'a']++;
            while (isValidSubstring(count)) {
                result += s.length() - right;
                 // Update count for the current and future substrings
                count[s.charAt(left) - 'a']--; 
                // Reduce the count for the character at the start
                left++; // Move the start of the window forward
            }   
            right++;
        }   
        return result;
    }
    public boolean isValidSubstring(int[] count) {
        return count[0] != 0 && count[1] != 0 && count[2] != 0;
    }
}