class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> timestamps = new TreeMap<>();
        for(int[] trip : trips) {
            int passengers = trip[0], to = trip[1], from = trip[2];
            timestamps.put(to, timestamps.getOrDefault(to, 0) + passengers);
            timestamps.put(from, timestamps.getOrDefault(from, 0) - passengers);
        }

        int usedCapacity = 0;
        for(int passengers : timestamps.values()) {
            usedCapacity+= passengers;
            if(usedCapacity > capacity) return false;
        }
        return true;
    }
}