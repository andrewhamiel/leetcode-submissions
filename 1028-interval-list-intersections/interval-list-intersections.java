class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        
        int firstInd = 0, secondInd = 0;
        while(firstInd < firstList.length && secondInd < secondList.length) {
            int[] first = firstList[firstInd], second = secondList[secondInd];

            int leftOverlap = Math.max(first[0], second[0]);
            int rightOverlap = Math.min(first[1], second[1]);
            if(leftOverlap <= rightOverlap) list.add(new int[]{leftOverlap, rightOverlap});
            if(first[1] <= second[1]) firstInd++;
            else secondInd++;
        }

        int[][] result = new int[list.size()][2];
        for(int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}