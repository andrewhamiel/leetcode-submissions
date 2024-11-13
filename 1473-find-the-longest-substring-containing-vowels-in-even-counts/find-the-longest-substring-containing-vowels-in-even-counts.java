class Solution {

    public int findTheLongestSubstring(String s) {
        //1. Character map
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;

        //2. First seen indeces
        int[] firstSeen = new int[32];
        Arrays.fill(firstSeen, -1);

        //3. Prefix XOR
        int prefixXOR = 0, longestSubstring = 0;
        for(int i = 0; i < s.length(); i++) {
            prefixXOR^= characterMap[s.charAt(i) - 'a'];
            if(firstSeen[prefixXOR] == -1 && prefixXOR != 0) firstSeen[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - firstSeen[prefixXOR]);
        }
        return longestSubstring;
    }
}