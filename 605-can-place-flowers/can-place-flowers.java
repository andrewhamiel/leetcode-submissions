class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length && n > 0; i++) {
            if(flowerbed[i] == 1) continue;

            boolean canPlaceLeft = i == 0 || flowerbed[i - 1] == 0;
            boolean canPlaceRight = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if(canPlaceLeft && canPlaceRight) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}