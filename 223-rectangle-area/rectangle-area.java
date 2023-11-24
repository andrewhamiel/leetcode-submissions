class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        //area A + areaB - sharedArea
        int sharedx1 = Math.max(ax1, bx1);
        int sharedx2 = Math.min(ax2, bx2);
        int xOverlap = sharedx2 - sharedx1;

        int sharedy1 = Math.max(ay1, by1);
        int sharedy2 = Math.min(ay2, by2);   
        int yOverlap = sharedy2 - sharedy1;

        int sharedArea = 0;
        if(xOverlap > 0 && yOverlap > 0){
            sharedArea = xOverlap * yOverlap;
        }

        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);
        return areaA + areaB - sharedArea;
    }
}