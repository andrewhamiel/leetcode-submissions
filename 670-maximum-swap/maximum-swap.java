class Solution {
    public int maximumSwap(int num) {
        if(num < 10) return num;
        char[] digits = String.valueOf(num).toCharArray();
        int[] rightmostIndex = new int[10];
        for(int i = 0; i < digits.length; i++) rightmostIndex[(int)(digits[i] - '0')] = i;
        for(int i = 0; i < digits.length; i++){
            int digit = (int)(digits[i] - '0');
            for(int nextNum = 9; nextNum > digit; nextNum--){
                if(rightmostIndex[nextNum] > i){
                    swap(i, rightmostIndex[nextNum], digits);
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return Integer.parseInt(new String(digits));
    }

    private void swap(int i, int j, char[] digits){
        char tmp = digits[i];
        digits[i] = digits[j];
        digits[j] = tmp;
    }
}