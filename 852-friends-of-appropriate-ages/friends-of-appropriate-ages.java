class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        for(int age : ages) freq[age]++;

        for(int i = 1; i < freq.length; i++) freq[i]+= freq[i - 1];

        int totalFriendRequests = 0;
        for(int age : ages){
            int condition = age/2 + 7;
            if(condition >= age) continue;
            totalFriendRequests+= freq[age] - freq[condition] - 1;
        }
        return totalFriendRequests;
    }
}