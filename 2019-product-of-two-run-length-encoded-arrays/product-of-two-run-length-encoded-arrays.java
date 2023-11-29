class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();

        int e1 = 0, e2 = 0;
        while(e1 < encoded1.length){
            int[] first = encoded1[e1], second = encoded2[e2];

            int common = Math.min(first[1], second[1]);
            int product = first[0] * second[0];

            if(!result.isEmpty() && result.get(result.size() - 1).get(0) == product){
                List<Integer> prev = result.get(result.size() - 1);
                int prevFreq = prev.get(1);
                prev.set(1, prevFreq + common);
                result.set(result.size() - 1, prev);
            }else{
                List<Integer> curr = new ArrayList<>();
                curr.add(product);
                curr.add(common);
                result.add(curr);
            }

            first[1]-= common;
            second[1]-= common;

            if(first[1] == 0) e1++;
            if(second[1] == 0) e2++;
        }
        return result;
    }
}