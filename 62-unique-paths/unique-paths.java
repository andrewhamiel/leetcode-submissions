class Solution {
    public int uniquePaths(int m, int n) {
        //Math: Catalan numbers
        long result = 1;
        for(int i = n; i < n + m - 1; i++) {
            result*= i;
            result/= (i - n + 1);
        }
        return (int) result;
    }
}