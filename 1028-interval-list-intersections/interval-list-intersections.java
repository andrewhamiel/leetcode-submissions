class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        Queue<int[]> q = new LinkedList<>();

        int firstInd = 0, secondInd = 0;
        while(firstInd < firstList.length && secondInd < secondList.length) {
            int[] first = firstList[firstInd], second = secondList[secondInd];

            int xOverlap = Math.max(first[0], second[0]);
            int yOverlap = Math.min(first[1], second[1]);
            if(xOverlap <= yOverlap) q.add(new int[]{xOverlap, yOverlap});

            if(first[1] <= second[1]) firstInd++;
            else secondInd++;
        }
        
        int[][] result = new int[q.size()][2];
        for(int i = 0; i < result.length; i++) result[i] = q.poll();
        return result;
    }
}