class Solution {
    public String customSortString(String order, String s) {
        int[] sFreqs = new int[26];
        for(char c : s.toCharArray()) sFreqs[c - 'a']++;

        StringBuilder result = new StringBuilder();
        for(char c : order.toCharArray()) {
            while(sFreqs[c - 'a'] > 0) {
                result.append(c);
                sFreqs[c - 'a']--;
            }
        }

        for(int i = 0; i < sFreqs.length; i++) {
            while(sFreqs[i] > 0) {
                result.append((char)(i + 'a'));
                sFreqs[i]--;
            }
        }
        return result.toString();
    }
}