class Solution {
    public int maximumLength(String s) {
        int[][] substrLengths = new int[26][3];
        for(int[] row : substrLengths) Arrays.fill(row, -1);

        int currLength = 0, longest = -1;
        char prev = '\0';

        for(char c : s.toCharArray()) {
            if(c == prev) currLength++;
            else {
                prev = c;
                currLength = 1;
            }

            int minLength = findMin((int)(c - 'a'), substrLengths);
            if(currLength > minLength) {
                if(substrLengths[c - 'a'][0] == minLength) substrLengths[c - 'a'][0] = currLength;
                else if(substrLengths[c - 'a'][1] == minLength) substrLengths[c - 'a'][1] = currLength;
                else substrLengths[c - 'a'][2] = currLength;
            }
        }

        for(int ind = 0; ind < substrLengths.length; ind++) {
            int minLength = findMin(ind, substrLengths);
            longest = Math.max(longest, minLength);
        }
        return longest;
    }

    private int findMin(int ind, int[][] substrLengths) {
        return Math.min(substrLengths[ind][0], Math.min(substrLengths[ind][1], substrLengths[ind][2]));
    }
}