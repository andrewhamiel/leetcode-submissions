class Solution {
    public int compress(char[] chars) {
        int compressedInd = 0, currLength = 1;
        char prev = chars[0];
        for(int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if(c == prev) currLength++;
            else {
                //Replace in array
                chars[compressedInd++] = prev;
                if(currLength > 1) {
                    for(char digit : String.valueOf(currLength).toCharArray()) chars[compressedInd++] = digit;
                }               
                //Reset values
                prev = c;
                currLength = 1;
            }
        }
        //Last letter
        chars[compressedInd++] = prev;
        if(currLength > 1) {
            for(char digit : String.valueOf(currLength).toCharArray()) chars[compressedInd++] = digit;
        }
        return compressedInd;
    }
}