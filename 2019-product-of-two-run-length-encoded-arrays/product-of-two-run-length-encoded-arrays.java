class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();

        int e1 = 0, e2 = 0;
        while(e1 < encoded1.length && e2 < encoded2.length){
            int[] first = encoded1[e1], second = encoded2[e2];
            
            int product = first[0] * second[0];
            int commonFreq = Math.min(first[1], second[1]);
            if(!result.isEmpty() && result.get(result.size() - 1).get(0) == product){
                List<Integer> prev = result.get(result.size() -1);
                int prevFreq = prev.get(1);
                prev.set(1, prevFreq + commonFreq);
                result.set(result.size() - 1, prev);
            }else{
                List<Integer> curr = new ArrayList<>();
                curr.add(product);
                curr.add(commonFreq);
                result.add(curr);
            }

            first[1]-= commonFreq;
            second[1]-= commonFreq;

            if(first[1] == 0) e1++;
            if(second[1] == 0) e2++;
        }
        return result;
    }
}