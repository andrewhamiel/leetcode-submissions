class Solution {
    public String frequencySort(String s) {
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap();
        for(Character c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
        }
        
        // Make the list of buckets and apply bucket sort.
        List<List<Character>> buckets = new ArrayList();
        for (int i = 0; i <= maxFreq; i++) {
            buckets.add(new ArrayList());
        }
        for (Character key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            buckets.get(freq).add(key);
        }

        // Build up the string. 
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.size() - 1; i >= 1; i--) {
            for (Character c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}