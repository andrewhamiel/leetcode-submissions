class Solution {
    public int maximumLength(String s) {
        int[][] substrLengths = new int[26][3];
        for(int[] row : substrLengths) Arrays.fill(row, -1);
        char prev = '\0';
        int currLength = 0;
        for(char c : s.toCharArray()) {
            if(c == prev) currLength++;
            else {
                prev = c;
                currLength = 1;
            }

            int ind = c - 'a';
            int minLength = getMin(ind, substrLengths);
            if(currLength > minLength) {
                if(substrLengths[ind][0] == minLength) substrLengths[ind][0] = currLength;
                else if(substrLengths[ind][1] == minLength) substrLengths[ind][1] = currLength;
                else substrLengths[ind][2] = currLength;
            }
        }

        int maxLength = -1;
        for(int ind = 0; ind < substrLengths.length; ind++) {
            maxLength = Math.max(maxLength, getMin(ind, substrLengths));
        }
        return maxLength;
    }

    private int getMin(int ind, int[][] substrLengths) {
        return Math.min(substrLengths[ind][0], Math.min(substrLengths[ind][1], substrLengths[ind][2]));
    }
}