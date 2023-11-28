class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[26];
        int oddCount = 0;
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
            oddCount+= freq[c - 'a'] % 2 == 0 ? -1 : 1;
        }
        return oddCount <= 1;
    }
}