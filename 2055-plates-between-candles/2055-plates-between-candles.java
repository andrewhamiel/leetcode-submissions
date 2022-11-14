class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length(), sum = 0;
        int[] psum = new int[n];
        //1. psum
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != '|') sum++;
            psum[i] = sum;
        }
        //2. left sum
        int[] leftCand = new int[n];
        Arrays.fill(leftCand, -1);
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '|') leftCand[i] = i;
            else leftCand[i] = i-1 >= 0 ? leftCand[i-1] : -1;
        }
        //3. right sum
        int[] rightCand = new int[n];
        Arrays.fill(rightCand, -1);
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '|') rightCand[i] = i;
            else rightCand[i] = i+1 < n ? rightCand[i+1] : -1;
        }
        //4. ans
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int leftQuery = queries[i][0], rightQuery = queries[i][1];
            int left = rightCand[leftQuery], right = leftCand[rightQuery];
            if(left == -1 || right == -1 || left >= right) ans[i] = 0;
            else ans[i] = psum[right] - psum[left];
        }
        return ans;
    }
}