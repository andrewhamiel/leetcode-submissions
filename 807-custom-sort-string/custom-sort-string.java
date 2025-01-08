class Solution {
    public String customSortString(String order, String s) {
        char[] freqs = new char[26];
        for(char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        for(char c : order.toCharArray()) {
            while(freqs[c - 'a'] > 0) {
                result.append(c);
                freqs[c - 'a']--;
            }
        }

        //append remaining chars
        for(int i = 0; i < freqs.length; i++) {
            while(freqs[i] > 0) {
                result.append((char)(i + 'a'));
                freqs[i]--;
            }
        }

        return result.toString();
    }
}