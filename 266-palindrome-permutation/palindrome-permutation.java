public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[26];
        int oddCount = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            if (freq[s.charAt(i) - 'a'] % 2 == 0)
                oddCount--;
            else
                oddCount++;
        }
        return oddCount <= 1;
    }
}