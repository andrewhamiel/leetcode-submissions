class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Key intuition here is that the arrays are both sorted
        //Want to do binary search, but need a way to do so without provisioning extra space to maintain runtime requirements. Can partition each array to do this and compare the partitions similar to a min and max heap
        
        //Base case: to avoid overflow error, nums1 must be <= nums2 length
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int left = 0, right = nums1.length; //Will handle
        //[left, right] variant
        while(left <= right) {
            int partitionA = left + (right - left)/2;
            int partitionB = (nums1.length + nums2.length + 1)/2 - partitionA;

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = partitionA == nums1.length ? Integer.MAX_VALUE : nums1[partitionA];

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = partitionB == nums2.length ? Integer.MAX_VALUE : nums2[partitionB];

            if(maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if((nums1.length + nums2.length) % 2 == 0) return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2;
                else return (double) (Math.max(maxLeftA, maxLeftB));
            }else if(maxLeftA > minRightB) right = partitionA - 1;
            else left = partitionA + 1;
        }
        return -1.0;
    }
}