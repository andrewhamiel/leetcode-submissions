class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();

        int e1 = 0, e2 = 0;
        while(e1 < encoded1.length && e2 < encoded2.length) {
            int[] first = encoded1[e1], second = encoded2[e2];

            int product = first[0] * second[0];
            int commonFreq = Math.min(first[1], second[1]);
            if(!result.isEmpty() && result.get(result.size() - 1).get(0) == product) {
                int prevFreq = result.get(result.size() - 1).get(1);
                result.get(result.size() - 1).set(1, prevFreq + commonFreq);
            }else {
                List<Integer> curr = Arrays.asList(product, commonFreq);
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