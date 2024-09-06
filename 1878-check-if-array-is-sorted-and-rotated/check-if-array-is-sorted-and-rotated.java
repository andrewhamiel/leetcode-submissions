class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Count points where the order "breaks"
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // Only one or zero discontinuities allowed
        return count <= 1;
    }
}