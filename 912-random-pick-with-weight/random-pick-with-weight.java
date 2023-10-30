class Solution {
    int[] w;

    public Solution(int[] w) {
        this.w = w;
        for(int i = 1; i < w.length; i++){
            w[i]+= w[i-1];
        }
    }
    
    public int pickIndex() {
        int right = w.length-1;
        int left = 0;
        double target = w[w.length - 1] * Math.random();
        while(left <= right){
            int mid = left + (right - left/2);
            if(w[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */