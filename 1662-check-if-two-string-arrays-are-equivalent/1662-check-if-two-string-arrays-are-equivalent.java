class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for(String word : word1) sb1.append(word);
        for(String word : word2) sb2.append(word);
        if(sb1.length() != sb2.length()) return false;
        for(int i = 0; i < sb1.length(); i++){
            if(sb1.charAt(i) != sb2.charAt(i)) return false;
        }
        return true;
    }
}