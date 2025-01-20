class Solution {
    private int[] w;
    private int total = 0;
    private Random rand = new Random();

    public Solution(int[] w) {
        for(int i = 1; i < w.length; i++) {
            w[i]+= w[i - 1];
        }
        this.w = w;
        total = w[w.length - 1];
    }
    
    public int pickIndex() {
        double target = rand.nextDouble(total);
        int left = 0, right = w.length;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(w[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */