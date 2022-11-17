class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int leftBound = Math.max(ax1, bx1), rightBound = Math.min(ax2, bx2);
        int upBound = Math.min(ay2, by2), downBound = Math.max(ay1, by1);
        int horizontal = rightBound - leftBound;
        int vertical = upBound - downBound;
        int overlap = 0;
        if(horizontal > 0 && vertical > 0) overlap = horizontal * vertical;
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        return area1 + area2 - overlap;
    }
}