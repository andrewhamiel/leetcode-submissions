class Solution {
    public int maximumLength(String s) {
        int substrLength = 0, result = -1;
        char prev = '\0';
        int[][] substrLengths = new int[26][3];

        for(int[] arr : substrLengths) Arrays.fill(arr, -1);

        for(char c : s.toCharArray()) {
            if(c == prev) substrLength++;
            else {
                substrLength = 1;
                prev = c;
            }

            //Replace min freq with curr length if it is greater
            int ind = c - 'a';
            int minLength = Math.min(substrLengths[ind][0], Math.min(substrLengths[ind][1], substrLengths[ind][2]));

            if(substrLength > minLength) {
                if(substrLengths[ind][0] == minLength) substrLengths[ind][0] = substrLength;
                else if(substrLengths[ind][1] == minLength) substrLengths[ind][1] = substrLength;
                else substrLengths[ind][2] = substrLength;
            }
        }

        //Find character with max value of its minimum frequence
        for(int i = 0; i < substrLengths.length; i++) {
            result = Math.max(result, Math.min(substrLengths[i][0], Math.min(substrLengths[i][1], substrLengths[i][2])));
        }
        return result;
    }
}