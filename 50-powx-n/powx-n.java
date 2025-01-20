class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.0;

        long pow = n;
        if(pow < 0) {
            x = 1/x;
            pow*= -1;
        }

        double result = 1;
        while(pow != 0) {
            if(pow % 2 != 0) {
                result*= x;
                pow--;
            }
            x*= x;
            pow/= 2;
        }
        return result;
    }
}