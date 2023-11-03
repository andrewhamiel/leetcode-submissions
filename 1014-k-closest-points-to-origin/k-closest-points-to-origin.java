class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickselect(points, 0, points.length - 1, k);
        int[][] ans = new int[k][2];
        for(int i = 0; i < ans.length; i++) ans[i] = points[i];
        return ans;
    }

    private void quickselect(int[][] points, int left, int right, int k){
        if(left >= right) return;
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        pivotIndex = partition(points, left, right, pivotIndex);
        if(pivotIndex == k) return;
        else if(pivotIndex < k) quickselect(points, pivotIndex + 1, right, k);
        else quickselect(points, left, pivotIndex - 1, k);
    }

    private int partition(int[][] points, int left, int right, int pivotIndex){
        int pivotDist = getDistance(points[pivotIndex]);
        swap(points, pivotIndex, right);
        pivotIndex = left;
        for(int i = left; i <= right; i++){
            if(getDistance(points[i]) <= pivotDist) swap(points, i, pivotIndex++);
        }
        return pivotIndex - 1;
    }

    private void swap(int[][] points, int i, int j){
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    private int getDistance(int[] point){
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}