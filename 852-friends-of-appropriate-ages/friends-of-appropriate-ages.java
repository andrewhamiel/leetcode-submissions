class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        for(int age : ages) freq[age]++;
        for(int i = 1; i < 121; i++) freq[i]+= freq[i - 1];

        int friendRequests = 0;
        for(int age : ages){
            int condition = age/2 + 7;
            if(condition >= age) continue;
            friendRequests+= freq[age] - freq[condition] - 1;
        }
        return friendRequests;
    }
}