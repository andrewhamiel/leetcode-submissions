class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = height[left], rightMax = height[right], vol = 0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                vol+= leftMax - height[left++];
            }else{
                rightMax = Math.max(rightMax, height[right]);
                vol+= rightMax - height[right--];
            }
        }
        return vol;
    }
}