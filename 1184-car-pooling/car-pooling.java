class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int[] trip : trips) {
            int passengers = trip[0], from = trip[1], to = trip[2];
            map.put(from, map.getOrDefault(from, 0) + passengers);
            map.put(to, map.getOrDefault(to, 0) - passengers);
        }

        int currPassengers = 0;
        for(int pos : map.keySet()) {
            currPassengers+= map.get(pos);
            if(currPassengers > capacity) return false;
        }
        return true;
    }
}