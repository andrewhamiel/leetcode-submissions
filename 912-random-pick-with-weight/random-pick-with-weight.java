class Solution {
    int[] w;
    int totalSum = 0;

    public Solution(int[] w) {
        for(int i = 1; i < w.length; i++) w[i]+= w[i-1];
        this.w = w;
        totalSum = w[w.length - 1];
    }
    
    public int pickIndex() {
        int left = 0, right = w.length;
        double target = totalSum * Math.random();

        while(left < right){
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