class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //1. Sort by priceA - priceB
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        //2. Send first half to city A
        int totalCost = 0, half = costs.length / 2;
        for(int i = 0; i < half; i++) {
            totalCost+= costs[i][0];
        }
        
        //3. Send second half to city B
        for(int i = half; i < costs.length; i++) {
            totalCost+= costs[i][1];
        }

        return totalCost;
    }
}