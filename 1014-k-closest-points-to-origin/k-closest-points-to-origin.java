class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(0, points.length - 1, points, k - 1);

        int[][] result = new int[k][2];
        for(int i = 0; i < result.length; i++) result[i] = points[i];
        return result;
    }

    private void quickselect(int left, int right, int[][] points, int k) {
        if(left >= right) return;

        int pivotInd = new Random().nextInt(right - left) + left;
        pivotInd = partition(left, right, points, pivotInd);

        if(pivotInd == k) return;
        else if(pivotInd < k) quickselect(pivotInd + 1, right, points, k);
        else quickselect(left, pivotInd - 1, points, k);
    }

    private int partition(int left, int right, int[][] points, int pivotInd) {
        int pivotDistance = getDistance(pivotInd, points);
        swap(pivotInd, right, points);
        int swapInd = left;
        for(int i = left; i <= right; i++) {
            if(getDistance(i, points) < pivotDistance) swap(swapInd++, i, points);
        }
        swap(swapInd, right, points);
        return swapInd;
    }

    private int getDistance(int ind, int[][] points) {
        int[] point = points[ind];
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    private void swap(int i, int j, int[][] points) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}