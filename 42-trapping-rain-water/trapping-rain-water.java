class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = height[left], rightMax = height[right], volume = 0;
        while(left < right){
            if(height[left] > height[right]){
                rightMax = Math.max(rightMax, height[right]);
                volume+= rightMax - height[right--];
            }else{
                leftMax = Math.max(leftMax, height[left]);
                volume+= leftMax - height[left++];
            }
        }
        return volume;
    }
}