class Solution {
    public int numFriendRequests(int[] ages) {
        //1. Age frequencies
        int[] freqs = new int[121];
        for(int age : ages) freqs[age]++;
        //2. Prefix sum
        for(int i = 1; i < freqs.length; i++) freqs[i]+= freqs[i - 1];
        //3. Calculate friend requests
        int totalFriendRequests = 0;
        for(int age : ages) {
            int condition = age / 2 + 7;
            if(condition >= age) continue;
            totalFriendRequests+= freqs[age] - freqs[condition] - 1; //Exclude person requesting
        }
        return totalFriendRequests;
    }
}