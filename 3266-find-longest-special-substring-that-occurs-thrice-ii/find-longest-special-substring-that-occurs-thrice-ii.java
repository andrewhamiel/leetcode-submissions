class Solution {
    public int maximumLength(String s) {
        int substrLength = 0, result = -1;
        char prev = '\0';
        int[][] substrLengths = new int[26][3];
        for(int[] arr : substrLengths) Arrays.fill(arr, -1);

        for(char c : s.toCharArray()) {
            if(c == prev) substrLength++;
            else {
                prev = c;
                substrLength = 1;
            }

            int ind = c - 'a';
            int minLength = Math.min(substrLengths[ind][0], Math.min(substrLengths[ind][1], substrLengths[ind][2]));

            if(substrLength > minLength) {
                if(substrLengths[ind][0] == minLength) substrLengths[ind][0] = substrLength;
                else if(substrLengths[ind][1] == minLength) substrLengths[ind][1] = substrLength;
                else substrLengths[ind][2] = substrLength;
            }
        }

        //Find longest special substring for each character
        for(int i = 0; i < substrLengths.length; i++) {
            int minLength = Integer.MAX_VALUE;
            for(int j = 0; j < substrLengths[i].length; j++) minLength = Math.min(minLength, substrLengths[i][j]);
            result = Math.max(result, minLength);
        }
        return result;
    }
}