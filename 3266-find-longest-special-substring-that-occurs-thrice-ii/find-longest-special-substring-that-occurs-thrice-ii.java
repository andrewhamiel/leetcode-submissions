class Solution {
    public int maximumLength(String s) {
        //Intuition: Can keep track of 3 largest substring lengths for each character
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

        //Find longest
        int longest = -1;
        for(int ind = 0; ind < substrLengths.length; ind++) {
            longest = Math.max(longest, getMin(ind, substrLengths));
        }
        return longest;
    }

    private int getMin(int ind, int[][] substrLengths) {
        return Math.min(substrLengths[ind][0], Math.min(substrLengths[ind][1], substrLengths[ind][2]));
    }
}