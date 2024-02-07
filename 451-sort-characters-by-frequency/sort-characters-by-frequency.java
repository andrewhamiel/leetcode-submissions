class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        Map<Integer, List<Character>> mapping = new HashMap<>();
        int maxFreq = 0;
        for(Map.Entry<Character, Integer> e : freq.entrySet()){
            mapping.putIfAbsent(e.getValue(), new ArrayList<>());
            mapping.get(e.getValue()).add(e.getKey());
            maxFreq = Math.max(maxFreq, e.getValue());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = maxFreq; i > 0; i--){
            if(mapping.containsKey(i)){
                for(Character c : mapping.get(i)){
                    for(int count = 0; count < i; count++) sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}