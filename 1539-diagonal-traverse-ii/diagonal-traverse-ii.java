class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int total = 0;
        for(int row = nums.size() - 1; row >= 0; row--){
            for(int col = 0; col < nums.get(row).size(); col++){
                int diagonal = row + col;
                map.putIfAbsent(diagonal, new ArrayList<>());
                map.get(diagonal).add(nums.get(row).get(col));
                total++;
            }
        }

        int[] result = new int[total];
        int curr = 0, i = 0;
        while(map.containsKey(curr)){
            for(Integer num : map.get(curr)){
                result[i++] = num; 
            }
            curr++;
        }
        return result;
    }
}