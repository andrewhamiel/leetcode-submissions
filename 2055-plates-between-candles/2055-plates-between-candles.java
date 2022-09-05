class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int len = s.length(), leftPlateCount = 0;
        int[]left= new int[len];
        TreeSet<Integer> candles = new TreeSet();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|') {
                candles.add(i);
                left[i] = leftPlateCount;
            }else leftPlateCount++;
        }
        int[] result = new int[queries.length];
        int i=0;
        for(int query[] : queries){
            Integer leftMostCandle = candles.ceiling(query[0]), rightMostCandle = candles.floor(query[1]);
            if(leftMostCandle!=null && rightMostCandle!=null && leftMostCandle<rightMostCandle)
                result[i] = left[rightMostCandle]-left[leftMostCandle];
            
            i++;
        }
        return result;
    }
}