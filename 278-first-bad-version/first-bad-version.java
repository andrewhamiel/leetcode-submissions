/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            boolean isBad = isBadVersion(mid);
            if(isBad && (mid == 0 || !isBadVersion(mid - 1))) return mid;
            else if(isBad) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}