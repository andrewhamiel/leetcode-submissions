class Solution {
    private int[][] matrix;
    private int rows, cols;

    public int kthSmallest(int[][] matrix, int k) {
        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        return quickselect(0, rows * cols - 1, rows * cols - k);
    }

    private int quickselect(int left, int right, int k){
        if(left >= right) return matrix[left / cols][left % cols];

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(left, right, pivotIndex);

        if(pivotIndex == k) return matrix[k / cols][k % cols];
        else if(pivotIndex < k) return quickselect(pivotIndex + 1, right, k);
        else return quickselect(left, pivotIndex - 1, k);
    }

    private int partition(int left, int right, int pivotIndex){
        int pivotValue = matrix[pivotIndex / cols][pivotIndex % cols];
        swap(pivotIndex, right);
        int swapIndex = left;

        for(int i = left; i <= right; i++){
            if(matrix[i / cols][i % cols] > pivotValue) swap(swapIndex++, i);
        }

        swap(swapIndex, right);
        return swapIndex;
    }

    private void swap(int i, int j){
        int tmp = matrix[i / cols][i % cols];
        matrix[i / cols][i % cols] = matrix[j / cols][j % cols];
        matrix[j / cols][j % cols] = tmp;
    }
}