class Solution {
    public int reverse(int x) {
        long result = 0;
        while(x != 0) {
            result*= 10;
            result+= x % 10;
            x/= 10;
        }
        return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int) result;
    }
}