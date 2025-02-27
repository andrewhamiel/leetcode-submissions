class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int left = 2, right = x / 2;
        //[left, right] variant
        while(left <= right) {
            int mid = left + (right - left)/2;
            long pow = (long)mid * mid;
            if(pow == x) return mid;
            else if(pow < x) left = mid + 1;
            else right = mid - 1;
        }
        return right; //round down
    }
}