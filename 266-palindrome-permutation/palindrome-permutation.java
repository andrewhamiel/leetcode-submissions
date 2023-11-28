class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[26];
        int oddCount = 0;
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            oddCount+= freq[s.charAt(i) - 'a'] % 2 == 0 ? -1 : 1;
        }
        return oddCount <= 1;
    }
}