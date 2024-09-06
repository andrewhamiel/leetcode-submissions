class Solution {
    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if(n == 0) return 1.0;

        if(n < 0) {
            x = 1/x;
            n*= -1;
        }

        double result = 1.0;
        while(n != 0) {
            if(n % 2 != 0) {
                result*= x;
                n--;
            }

            x*= x;
            n/= 2;
        }
        return result;
    }
}