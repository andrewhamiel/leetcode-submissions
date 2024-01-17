class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : arr) freq.put(num, freq.getOrDefault(num, 0) + 1);

        Set<Integer> seen = new HashSet<>();
        for(int key : freq.keySet()){
            if(seen.contains(freq.get(key))) return false;
            seen.add(freq.get(key));
        }
        return true;
    }
}