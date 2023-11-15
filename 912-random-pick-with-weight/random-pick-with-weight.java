class Solution {
    int[] weight;
    int sum = 0;

    public Solution(int[] w) {
        weight = w;
        for(int i = 1; i < weight.length; i++) weight[i]+= weight[i-1];      
        sum = weight[weight.length - 1];
    }
    
    public int pickIndex() {
        double target = sum * Math.random();

        int left = 0, right = weight.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(weight[mid] < target) left = mid + 1;
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