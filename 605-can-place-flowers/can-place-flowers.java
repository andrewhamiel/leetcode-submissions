class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++) {
            //if flower already planted
            if(flowerbed[i] == 1) continue;

            boolean isLeftFree = i == 0 || flowerbed[i - 1] == 0;
            boolean isRightFree = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

            if(isLeftFree && isRightFree) {
                flowerbed[i] = 1; //Mark to not count neighbors as well
                count++;
            }
        }
        return count >= n;
    }
}