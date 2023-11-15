class Solution {
    public String customSortString(String order, String s) {
        int[] sFreq = new int[26];
        for(Character c : s.toCharArray()) sFreq[c - 'a']++;

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            Character c = order.charAt(i);
            while(sFreq[c - 'a']-- > 0){
                result.append(c);
            }
        }

        for(int i = 0; i < 26; i++){
            while(sFreq[i]-- > 0) {
                result.append((char)(i + 'a'));
            }
        }

        return result.toString();
    }
}