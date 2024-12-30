class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftHeight = height[left], rightHeight = height[right], vol = 0;
        while(left < right) {
            if(height[left] < height[right]) {
                leftHeight = Math.max(leftHeight, height[left]);
                vol+= leftHeight - height[left++];
            }else {
                rightHeight = Math.max(rightHeight, height[right]);
                vol+= rightHeight - height[right--];
            }
        }
        return vol;
    }
}