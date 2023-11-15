class Solution {
    private int[][] points;

    public int[][] kClosest(int[][] points, int k) {
        this.points = points;
        quickselect(0, points.length - 1, k);

        int[][] result = new int[k][2];
        for(int i = 0; i < result.length; i++) result[i] = points[i];
        return result;
    }

    private void quickselect(int left, int right, int k){
        if(left >= right) return;

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(left, right, pivotIndex);

        if(pivotIndex == k) return;
        else if(pivotIndex < k) quickselect(pivotIndex + 1, right, k);
        else quickselect(left, pivotIndex - 1, k);
    }

    private int partition(int left, int right, int pivotIndex){
        int pivotDistance = getDistance(pivotIndex);
        swap(pivotIndex, right);
        int swapIndex = left;

        for(int i = left; i <= right; i++){
            if(getDistance(i) < pivotDistance) swap(swapIndex++, i);
        }
        swap(swapIndex, right);
        return swapIndex;
    }

    private void swap(int i, int j){
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int getDistance(int pivotIndex){
        return (points[pivotIndex][0] * points[pivotIndex][0]) + (points[pivotIndex][1] * points[pivotIndex][1]);
    }
}