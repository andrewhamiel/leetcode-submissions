class Solution {
    public long numberOfWays(String s) {
        long[] endsWithZero = new long[2], endsWithOne = new long[2];
        long ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ans+=endsWithZero[1];
                endsWithOne[0]++;
                endsWithOne[1]+=endsWithZero[0];
            }else{
                ans+=endsWithOne[1];
                endsWithZero[0]++;
                endsWithZero[1]+=endsWithOne[0];
            }
        }
        return ans;
    }
}