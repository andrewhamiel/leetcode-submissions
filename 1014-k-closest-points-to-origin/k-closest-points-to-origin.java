class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(0, points.length - 1, points, k - 1);
        int[][] result = new int[k][2];
        for(int i = 0; i < result.length; i++) result[i] = points[i];
        return result;
    }

    private void quickselect(int left, int right, int[][] points, int k){
        if(left >= right) return;

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(left, right, points, pivotIndex);

        if(pivotIndex == k) return;
        else if(pivotIndex < k) quickselect(pivotIndex + 1, right, points, k);
        else quickselect(left, pivotIndex - 1, points, k);
    }

    private int partition(int left, int right, int[][] points, int pivotIndex){
        int pivotDistance = getDistance(points, pivotIndex);
        swap(pivotIndex, right, points);
        int swapIndex = left;

        for(int i = left; i <= right; i++){
            if(getDistance(points, i) < pivotDistance) swap(i, swapIndex++, points);
        }
        swap(swapIndex, right, points);
        return swapIndex;
    }

    private void swap(int i, int j, int[][] points){
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int getDistance(int[][] points, int p){
        return (points[p][0] * points[p][0]) + (points[p][1] * points[p][1]);
    }
}