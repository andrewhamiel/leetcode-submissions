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

            int ind = c - 'a';
            int minLength = substrLengths[ind][0];
            for(int j = 1; j < substrLengths[ind].length; j++) minLength = Math.min(minLength, substrLengths[ind][j]);

            if(substrLength > minLength) {
                for(int j = 0; j < substrLengths[ind].length; j++) {
                    if(substrLengths[ind][j] == minLength) {
                        substrLengths[ind][j] = substrLength;
                        break;
                    }
                }
            }
        }

        for(int[] substr : substrLengths) {
            int minLength = substr[0];
            for(int j = 0; j < substr.length; j++) minLength = Math.min(minLength, substr[j]);
            result = Math.max(result, minLength); 
        }
        return result;
    }
}