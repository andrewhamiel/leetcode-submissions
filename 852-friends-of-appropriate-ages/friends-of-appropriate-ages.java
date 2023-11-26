class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        for(int age : ages) freq[age]++;

        for(int i = 1; i < freq.length; i++) freq[i]+= freq[i - 1];

        int totalFriendRequests = 0;
        for(int i = 0; i < ages.length; i++){
            int condition = ages[i]/2 + 7;
            if(condition >= ages[i]) continue;
            totalFriendRequests+= freq[ages[i]] - freq[condition] - 1;
        }
        return totalFriendRequests;
    }
}