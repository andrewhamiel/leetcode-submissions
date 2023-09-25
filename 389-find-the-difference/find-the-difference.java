class Solution {
    public char findTheDifference(String s, String t) {
        int[] sFreq = new int[26], tFreq = new int[26];
        for(Character c : s.toCharArray()) sFreq[c - 'a']++;
        for(Character c : t.toCharArray()) tFreq[c - 'a']++;
        for(int i = 0; i < 26; i++){
            if(sFreq[i] != tFreq[i]) return (char)(i + 'a');
        }
        return ' ';
    }
}