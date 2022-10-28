class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        int[] chars = new int[26];
        for(String str : strs){
            Arrays.fill(chars, 0);
            //O(n)
            for(Character ch : str.toCharArray()) chars[ch - 'a']++;
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++){
                sb.append("#");
                sb.append(chars[i]);
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}