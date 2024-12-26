class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freqs = new int[121];
        for(int age : ages) freqs[age]++;

        for(int i = 1; i < freqs.length; i++) freqs[i]+= freqs[i - 1];

        int totalFriendRequests = 0;
        for(int age : ages) {
            int condition = age / 2 + 7;
            if(condition >= age) continue;
            totalFriendRequests+= freqs[age] - freqs[condition] - 1;
        }
        return totalFriendRequests;
    }
}