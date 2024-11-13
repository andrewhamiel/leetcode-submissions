class Solution {
    public int maximumSwap(int num) {
        int[] rightmost = new int[10];
        char[] arr = String.valueOf(num).toCharArray();
        for(int i = 0; i < arr.length; i++) rightmost[arr[i] - '0'] = i;

        for(int i = 0; i < arr.length; i++) {
            for(char c = '9'; c > arr[i]; c--) {
                if(rightmost[c - '0'] > i) {
                    swap(i, rightmost[c - '0'], arr);
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return Integer.parseInt(new String(arr));
    }

    private void swap(int i, int j, char[] arr) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}