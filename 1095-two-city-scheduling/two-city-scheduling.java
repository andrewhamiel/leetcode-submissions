class Solution {
    public int twoCitySchedCost(int[][] costs) {
        //1. Sort based on priceA - priceB. 
        //[10, 20] = 10 - 20 = -10. Cheaper to send to city A
        //[400, 50] = 400 - 50 = 350. Cheaper to send to city B
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        //2. Send first half to city A
        int totalCost = 0, n = costs.length / 2;
        for(int i = 0; i < n; i++) {
            totalCost+= costs[i][0];
        }
        //3. Send second half to city B
        for(int i = n; i < costs.length; i++) {
            totalCost+= costs[i][1];
        }
        return totalCost;
    }
}