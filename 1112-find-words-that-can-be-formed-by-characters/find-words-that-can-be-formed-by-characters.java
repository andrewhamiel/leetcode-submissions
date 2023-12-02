class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        for(char c : chars.toCharArray()) freq[c - 'a']++;

        int count = 0;
        for(String word : words){
            boolean isFormed = true;
            int[] copy = Arrays.copyOf(freq, freq.length);
            for(char c : word.toCharArray()) if(copy[c - 'a']-- <= 0){
                isFormed = false;
                break;
            }
            if(isFormed) count+= word.length();
        }
        return count;
    }
}