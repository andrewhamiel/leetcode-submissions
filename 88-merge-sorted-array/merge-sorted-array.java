class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptrA = m - 1, ptrB = n - 1;
        for(int i = nums1.length - 1; i >= 0; i--) {
            if(ptrA >= 0 && ptrB >= 0) {
                if(nums1[ptrA] >= nums2[ptrB]) nums1[i] = nums1[ptrA--];
                else nums1[i] = nums2[ptrB--];
            }else if(ptrA >= 0) {
                nums1[i] = nums1[ptrA--];
            }else if(ptrB >= 0) {
                nums1[i] = nums2[ptrB--];
            }
        }
    }
}