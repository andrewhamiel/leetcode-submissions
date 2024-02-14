class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> seen2 = new HashSet<>(), seen1 = new HashSet<>();
        for(int num : nums1) seen1.add(num);
        for(int num : nums2) seen2.add(num);

        int firstInd = 0, secondInd = 0;
        for(int i = 0; i < nums1.length; i++){
            if(seen2.contains(nums1[i])){
                firstInd++;
            }
        }


        for(int i = 0; i < nums2.length; i++){
            if(seen1.contains(nums2[i])){
                secondInd++;
            }
        }
        return new int[]{firstInd,secondInd};
    }
}