class Solution {
    public int maximumSum(int[] arr) {
        int oneDelete = 0, noDelete = arr[0], result = arr[0];
        for(int i = 1; i < arr.length; i++){
            oneDelete = Math.max(oneDelete + arr[i], noDelete);
            noDelete = Math.max(noDelete + arr[i], arr[i]);
            result = Math.max(result, Math.max(noDelete, oneDelete));
        }
        return result;
    }
}