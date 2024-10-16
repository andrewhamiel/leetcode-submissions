class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Queue<int[]> q = new LinkedList<>();

        int firstInd = 0, secondInd = 0;
        while(firstInd < firstList.length && secondInd < secondList.length) {
            int[] currFirst = firstList[firstInd], currSecond = secondList[secondInd];

            //first ends later 
            int xOverlap = Math.max(currFirst[0], currSecond[0]);
            int yOverlap = Math.min(currFirst[1], currSecond[1]);
            if(xOverlap <= yOverlap) q.add(new int[]{xOverlap, yOverlap});

            //determine which ends first
            if(currFirst[1] >= currSecond[1]) secondInd++;
            else firstInd++;
        }

        int[][] result = new int[q.size()][2];
        for(int i = 0; i < result.length; i++) result[i] = q.poll();
        return result;
    }
}