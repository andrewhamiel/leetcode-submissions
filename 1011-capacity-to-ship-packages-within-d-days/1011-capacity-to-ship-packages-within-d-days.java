class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int sum = 0;
        for(int i = 0; i<weights.length; i++){
            sum += weights[i];
        }
        int end = sum,  ans = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(ispossible(weights,mid,days)){
                ans = mid;
                end = mid - 1;
            }else start = mid + 1;
        }
        return ans;
    }
    
    public boolean ispossible(int[] weights,int mid,int d){
        int days = 1, capacity = 0;
        for(int i = 0; i < weights.length; i++){
            if(capacity+weights[i] <= mid) capacity += weights[i];
            else{
                days++;
                capacity = 0;
                if(days > d || weights[i] > mid) return false;
                capacity += weights[i];
            }
        }
        return true;
    }
}