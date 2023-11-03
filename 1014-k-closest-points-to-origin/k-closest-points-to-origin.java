class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(0, points.length - 1, points, k);
        int[][] ans = new int[k][2];
        for(int i = 0; i < ans.length; i++) ans[i] = points[i];
        return ans;
    }

    private void quickselect(int left, int right, int[][] points, int k){
        if(left >= right) return;

        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        pivotIndex = partition(left, right, points, pivotIndex);
        if(pivotIndex == k) return;
        else if(pivotIndex < k) quickselect(pivotIndex + 1, right, points, k);
        else quickselect(left, pivotIndex - 1, points, k);
    }

    private int partition(int left, int right, int[][] points, int pivotIndex){
        int pivotDistance = getDistance(points[pivotIndex]);
        swap(pivotIndex, right, points);
        pivotIndex = left;
        for(int i = left; i <= right; i++){
            if(getDistance(points[i]) <= pivotDistance) swap(i, pivotIndex++, points);
        }
        return pivotIndex - 1;
    }

    private void swap(int i, int j, int[][] points){
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int getDistance(int[] point){
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}