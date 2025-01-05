class Solution {
    public int trap(int[] height) {
        int[] leftHeights = new int[height.length], rightHeights = new int[height.length];
        //Left hand: monotonically non-decreasing
        leftHeights[0] = height[0];
        for(int i = 1; i < leftHeights.length; i++) leftHeights[i] = Math.max(leftHeights[i - 1], height[i]);
        //Right hand: monotonically non-increasing
        rightHeights[rightHeights.length - 1] = height[height.length - 1];
        for(int i = rightHeights.length - 2; i >= 0; i--) rightHeights[i] = Math.max(rightHeights[i + 1], height[i]);

        //Compare for volume
        int vol = 0;
        for(int i = 0; i < height.length; i++) {
            int minPrefixHeight = Math.min(leftHeights[i], rightHeights[i]);
            if(height[i] < minPrefixHeight) vol+= minPrefixHeight - height[i];
        }
        return vol;
    }
}