class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamps = new int[1001];
        for(int[] trip : trips) {
            int passengers = trip[0], from = trip[1], to = trip[2];
            timestamps[from]+= passengers;
            timestamps[to]-= passengers;
        }

        int usedCapacity = 0;
        for(int passengers : timestamps) {
            usedCapacity+= passengers;
            if(usedCapacity > capacity) return false;
        }
        return true;
    }
}