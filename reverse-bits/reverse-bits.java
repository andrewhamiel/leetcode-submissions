public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int t = 0;
        for (int i = 0; i < 32; i++, n >>>= 1) {
            t <<= 1;
            t |= n & 1;
        }
        return t;
    }
}