class Solution {
    public String customSortString(String order, String s) {
        int[] sFreq = new int[26];
        for(Character c : s.toCharArray()){
            sFreq[(int)(c - 'a')]++;
        }

        StringBuilder sb = new StringBuilder();
        for(Character c : order.toCharArray()){
            while(sFreq[c - 'a'] > 0){
                sb.append(c);
                sFreq[c - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++){
            while(sFreq[i] > 0){
                sb.append((char)(i + 'a'));
                sFreq[i]--;
            }
        }

        return sb.toString();
    }
}