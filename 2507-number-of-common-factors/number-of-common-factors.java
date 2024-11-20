class Solution {
    public int commonFactors(int a, int b) {
        if(a > b) return commonFactors(b, a);
        int factors = 0;
        for(int i = 1; i <= a; i++) {
            if(a % i == 0 && b % i == 0) factors++;
        }
        return factors;
    }
}