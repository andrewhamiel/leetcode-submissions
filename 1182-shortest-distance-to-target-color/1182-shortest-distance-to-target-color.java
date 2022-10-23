class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int[][] dp = new int[colors.length][3];
        for(int i = 1; i <= 3; i++){
            if(colors[colors.length - 1] == i) dp[colors.length-1][i-1] = colors.length - 1;
            else dp[colors.length-1][i-1] = -1;
        }
        //backwards
        for(int i = colors.length - 2; i >= 0; i--){
            dp[i][colors[i] - 1] = i;
            if(colors[i] == 1){
                dp[i][1] = dp[i+1][1]; //color 2
                dp[i][2] = dp[i+1][2]; //color 3
            }else if(colors[i] == 2){
                dp[i][0] = dp[i+1][0]; //color 1
                dp[i][2] = dp[i+1][2]; //color 3
            }else if(colors[i] == 3){
                dp[i][0] = dp[i+1][0]; //color 1
                dp[i][1] = dp[i+1][1]; //color 2
            }
        }
        //forward
        int one = -1, two = -1, three = -1;
        for(int i = 0; i < colors.length; i++){
            if(colors[i] == 1) one = i;
            else if(colors[i] == 2) two = i;
            else if(colors[i] == 3) three = i;
            if(one != -1 && Math.abs(i - one) < Math.abs(i - dp[i][0])) dp[i][0] = one;
            if(two != -1 && Math.abs(i-two) < Math.abs(i - dp[i][1])) dp[i][1] = two;
            if(three != -1 && Math.abs(i-three) < Math.abs(i - dp[i][2])) dp[i][2] = three;
        }
        List<Integer> result = new ArrayList();
        for(int[] query : queries){
            int closestInd = dp[query[0]][query[1]-1];
            if(closestInd != -1) closestInd = Math.abs(query[0] - closestInd);
            result.add(closestInd);
        }
        return result;
    }
}