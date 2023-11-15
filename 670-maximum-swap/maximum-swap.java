class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        int[] rightmost = new int[10];
        for(int i = 0; i < arr.length; i++) rightmost[arr[i] - '0'] = i;

        for(int i = 0; i < arr.length; i++){
            int currDigit = arr[i] - '0';
            for(int j = 9; j > currDigit; j--){
                if(rightmost[j] > i){
                    swap(i, rightmost[j], arr);
                    return Integer.parseInt(new String(arr));
                }
                
            }
        }
        return num;
    }

    private void swap(int i, int j, char[] nums){
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}