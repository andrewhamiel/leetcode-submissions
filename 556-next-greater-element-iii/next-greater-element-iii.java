class Solution {
    public int nextGreaterElement(int n) {
        //find first monotonically increasing subsequence
        char[] arr = String.valueOf(n).toCharArray();
        int[] rightmost = new int[10];
        for(int i = 0; i < arr.length; i++) rightmost[(int)(arr[i] - '0')] = i;
        int i = arr.length - 2;
        boolean isSwapped = false;
        while( i >= 0){
            int val = (int)(arr[i] - '0');
            for(int j = val + 1; j < 10; j++){
                if(rightmost[j] > i){
                    swap(i, rightmost[j], arr);
                    isSwapped = true;
                    break;
                }
            }
            if(isSwapped) break;
            i--;
        }
        
        long check = Long.parseLong(new String(arr));
        if(check == (long)n) return -1;
        reverse(i + 1, arr.length - 1, arr);

        int test = Integer.MAX_VALUE;
        long sizeCheck = Long.parseLong(new String(arr));
        if(sizeCheck > (long)Integer.MAX_VALUE) return -1;
        
        return Integer.parseInt(new String(arr));
    }

    private void swap(int i, int j, char[] arr){
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(int i, int j, char[] arr){
        while(i < j){
            swap(i++, j--, arr);
        }
    }
}