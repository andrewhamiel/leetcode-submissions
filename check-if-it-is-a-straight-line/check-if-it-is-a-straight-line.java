class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int firstdX = coordinates[0][0] - coordinates[1][0];
        int firstdY = coordinates[0][1] - coordinates[1][1];
        for (int i = 2; i < coordinates.length; ++i) {
            int[] point = coordinates[i], prev = coordinates[i-1];
            int nextdX = point[0] - prev[0];
            int nextdY = point[1] - prev[1];
            if ( firstdX * nextdY != nextdX * firstdY) return false;
        }
        return true;
    }
}