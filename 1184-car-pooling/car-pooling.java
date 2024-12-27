class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamps = new int[1001];
        for(int[] trip : trips) {
            int passengers = trip[0], to = trip[1], from = trip[2];
            timestamps[to]+= passengers;
            timestamps[from]-= passengers;
        }

        int usedCapacity = 0;
        for(int passengers : timestamps) {
            usedCapacity+= passengers;
            if(usedCapacity > capacity) return false;
        }
        return true;
    }
}