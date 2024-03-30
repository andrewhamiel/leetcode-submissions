class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int left = 0, right = nums1.length;
        while(left <= right){
            int midAndPartitionA = left + (right - left)/2;
            int partitionB = (nums1.length + nums2.length + 1)/2 - midAndPartitionA;

            int maxLeftA = midAndPartitionA == 0 ? Integer.MIN_VALUE : nums1[midAndPartitionA - 1];
            int minRightA = midAndPartitionA == nums1.length ? Integer.MAX_VALUE : nums1[midAndPartitionA];

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = partitionB == nums2.length ? Integer.MAX_VALUE : nums2[partitionB];

            if(maxLeftA <= minRightB && maxLeftB <= minRightA){
                if((nums1.length + nums2.length) % 2 == 0) return (double)(Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB))/2;
                else return Math.max(maxLeftA, maxLeftB);
            }else if(maxLeftA > minRightB) right = midAndPartitionA - 1; //left partition too large
            else left = midAndPartitionA + 1; //right partition too large
        }
        return -1.0;
    }
}