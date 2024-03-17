class Solution {
    public int minimumKeypresses(String s) {
        int result = 0;
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);

        for(char c : s.toCharArray()) count[c - 'a']++;

        Arrays.sort(count, (a, b) -> b - a);

        for(int i = 0; i < 26; i++){
            if(i < 9) result+= count[i];
            else if(i < 18) result+= 2 * count[i];
            else result+= 3 * count[i];
        }
        return result;
    }
}