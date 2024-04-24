class Solution {
    public int tribonacci(int n) {
        if(n < 2) return n;
        if(n == 2) return 1;

        int t0 = 0, t1 = 1, t2 = 1;
        for(int i = 3; i <= n; i++){
            int tmp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tmp;
        }
        return t2;
    }
}