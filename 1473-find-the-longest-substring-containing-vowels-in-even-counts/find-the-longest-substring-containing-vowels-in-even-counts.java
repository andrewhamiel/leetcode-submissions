class Solution {
    public int findTheLongestSubstring(String s) {
        //1. Character map
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;

        //2. First seen
        int[] firstSeen = new int[32];
        Arrays.fill(firstSeen, -1);

        //3. PrefixXOR
        int prefixXOR = 0, longest = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            prefixXOR^= characterMap[c - 'a'];
            if(firstSeen[prefixXOR] == -1 && prefixXOR != 0) firstSeen[prefixXOR] = i;
            longest = Math.max(longest, i - firstSeen[prefixXOR]);
        }
        return longest;
    }
}