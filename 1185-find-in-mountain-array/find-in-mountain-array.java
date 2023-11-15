/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        Map<Integer, Integer> cache = new HashMap<>();
        int length = mountainArr.length();

        int left = 1, right = length - 2;
        while(left < right){
            int mid = left + (right - left)/2;

            int curr = cache.getOrDefault(mid, mountainArr.get(mid));
            cache.putIfAbsent(mid, curr);

            int nextNum = cache.getOrDefault(mid+1, mountainArr.get(mid+1));
            cache.putIfAbsent(mid+1, nextNum);

            if(curr < nextNum){
                if(curr == target) return mid;
                if(nextNum == target) return mid + 1;
                left = mid + 1;
            }else right = mid;
        }

        int peakIndex = left;

        left = 0; right = peakIndex;
        while(left <= right){
            int mid = left + (right - left)/2;

            int curr = cache.getOrDefault(mid, mountainArr.get(mid));

            if(curr == target) return mid;
            else if(curr < target) left = mid + 1;
            else right = mid - 1;
        }

        left = peakIndex + 1; right = length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;

            int curr = cache.getOrDefault(mid, mountainArr.get(mid));

            if(curr == target) return mid;
            else if(curr > target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}