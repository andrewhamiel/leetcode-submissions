class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(0, points.length - 1, points, k - 1);
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) result[i] = points[i];
        return result;
    }

    private void quickselect(int left, int right, int[][] points, int k) {
        if(left >= right) return;

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(left, right, points, pivotIndex);

        if(pivotIndex == k) return;
        else if(pivotIndex < k) quickselect(pivotIndex + 1, right, points, k);
        else quickselect(left, pivotIndex - 1, points, k);
    }

    private int partition(int left, int right, int[][] points, int pivotInd) {
        int pivotDistance = getDistance(pivotInd, points);
        swap(pivotInd, right, points);
        int swapIndex = left;
        for(int i = left; i <= right; i++) {
            if(getDistance(i, points) < pivotDistance) swap(swapIndex++, i, points);
        }
        swap(swapIndex, right, points);
        return swapIndex;
    }

    private void swap(int i, int j, int[][] points) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int getDistance(int i, int[][] points) {
        return (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
    }
}