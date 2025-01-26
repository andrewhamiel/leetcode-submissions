class Solution {
    private int rows = 0;
    private int cols = 0;

    public int kthSmallest(int[][] matrix, int k) {
        rows = matrix.length;
        cols = matrix[0].length;
        return quickselect(0, rows * cols  - 1, matrix, k - 1);
    }

    private int quickselect(int left, int right, int[][] matrix, int k) {
        if(left >= right) return matrix[left / cols][left % cols];

        int pivotInd = new Random().nextInt(right - left) + left;
        pivotInd = partition(left, right, matrix, pivotInd);
        
        if(pivotInd == k) return matrix[k / cols][k % cols];
        else if(pivotInd < k) return quickselect(pivotInd + 1, right, matrix, k);
        else return quickselect(left, pivotInd - 1, matrix, k);
    }

    private int partition(int left, int right, int[][] matrix, int pivotInd) {
        int pivotValue = matrix[pivotInd / cols][pivotInd % cols];
        swap(pivotInd, right, matrix);
        int swapInd = left;
        for(int i = left; i <= right; i++) {
            if(matrix[i / cols][i % cols] < pivotValue) swap(swapInd++, i, matrix);
        }
        swap(swapInd, right, matrix);
        return swapInd;
    }

    private void swap(int i, int j, int[][] matrix) {
        int tmp = matrix[i / cols][i % cols];
        matrix[i / cols][i % cols] = matrix[j / cols][j % cols];
        matrix[j / cols][j % cols] = tmp;
    }
}