class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);

        for(int i = 1; i < words.length; i++){
            String word1 = words[i - 1], word2 = words[i];
            for(int wordInd = 0; wordInd < word1.length(); wordInd++){
                if(wordInd >= word2.length()) return false;

                char c1 = word1.charAt(wordInd), c2 = word2.charAt(wordInd);
                if(c1 != c2){
                    if(map.get(c1) > map.get(c2)) return false;
                    break;
                }
            }
        }
        return true;
    }
}