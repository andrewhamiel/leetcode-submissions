class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamps = new int[1001];
        for(int[] trip : trips) {
            int passengers = trip[0], from = trip[1], to = trip[2];
            timestamps[from]+= passengers;
            timestamps[to]-= passengers;
        }

        int currCapacity = 0;
        for(int i = 0; i < timestamps.length; i++) {
            currCapacity+= timestamps[i];
            if(currCapacity > capacity) return false;
        }
        return true;
    }
}