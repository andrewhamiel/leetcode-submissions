class Solution {
    public int maximumLength(String s) {
        int[][] substrLengths = new int[26][3];
        for(int[] row : substrLengths) Arrays.fill(row, -1);
        char prev = '\0';
        int currLength = 0;
        for(char c : s.toCharArray()) {
            if(c == prev) currLength++;
            else {
                currLength = 1;
                prev = c;
            }

            int ind = c - 'a';
            int minLength = getMin(ind, substrLengths);
            if(currLength > minLength) {
                if(substrLengths[ind][0] == minLength) substrLengths[ind][0] = currLength;
                else if(substrLengths[ind][1] == minLength) substrLengths[ind][1] = currLength;
                else substrLengths[ind][2] = currLength;
            }
        }

        int longest = -1;
        for(int ind = 0; ind < substrLengths.length; ind++) {
            int minLength = getMin(ind, substrLengths);
            longest = Math.max(longest, minLength);
        }
        return longest;
    }

    private int getMin(int ind, int[][] substrLengths) {
        return Math.min(substrLengths[ind][0], Math.min(substrLengths[ind][1], substrLengths[ind][2]));
    }
}