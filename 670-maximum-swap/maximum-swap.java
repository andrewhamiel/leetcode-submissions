class Solution {
    public int maximumSwap(int num) {
        if(num < 10) return num;
        char[] digits = String.valueOf(num).toCharArray();
        int[] rightmostIndex = new int[10];

        for(int i = 0; i < digits.length; i++){
            rightmostIndex[digits[i] - '0'] = i;
        }

        for(int i = 0; i < digits.length; i++){
            for(int digit = '9'; digit > '0'; digit--){
                if(digit > digits[i] && rightmostIndex[digit - '0'] > i){
                    swap(i, rightmostIndex[digit - '0'], digits);
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }

    private void swap(int i, int j, char[] digits){
        char tmp = digits[i];
        digits[i] = digits[j];
        digits[j] = tmp;
    }
}