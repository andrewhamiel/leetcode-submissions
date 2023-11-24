class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomFreq = new int[26], magazineFreq = new int[26];
        for(char c : ransomNote.toCharArray()) ransomFreq[c - 'a']++;
        for(char c : magazine.toCharArray()) magazineFreq[c - 'a']++;

        for(int i = 0; i < 26; i++){
            if(ransomFreq[i] > magazineFreq[i]) return false;
        }
        return true;
    }
}