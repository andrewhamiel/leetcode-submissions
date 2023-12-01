class Solution {
    public String customSortString(String order, String s) {
        int[] sFreq = new int[26];
        for(char c : s.toCharArray()) sFreq[c - 'a']++;

        StringBuilder result = new StringBuilder();
        for(char c : order.toCharArray()){
            while(sFreq[c - 'a'] > 0){
                result.append(c);
                sFreq[c - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++){
            while(sFreq[i] > 0) {
                result.append((char)(i + 'a'));
                sFreq[i]--;
            }
        }
        return result.toString();
    }
}