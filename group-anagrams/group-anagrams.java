class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            map.putIfAbsent(sorted, new ArrayList());
            map.get(sorted).add(str);
        }
        
        List<List<String>> result = new ArrayList();
        for(String key : map.keySet()) result.add(map.get(key));
        return result;
    }
}