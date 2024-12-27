class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> timestamps = new TreeMap<>();
        for(int[] trip : trips) {
            timestamps.put(trip[1], timestamps.getOrDefault(trip[1], 0) + trip[0]);
            timestamps.put(trip[2], timestamps.getOrDefault(trip[2], 0) - trip[0]);
        }

        int usedCapacity = 0;
        for(int passengers : timestamps.values()) {
            usedCapacity+= passengers;
            if(usedCapacity > capacity) return false;
        }
        return true;
    }
}