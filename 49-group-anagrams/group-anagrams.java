class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] freqs = new int[26];
            for(char c : str.toCharArray()) freqs[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for(int num : freqs) sb.append((char)(num + 'a'));
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}