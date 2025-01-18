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
                    String digits = String.valueOf(currLength);
                    for(char digit : digits.toCharArray()) chars[compressedInd++] = digit;
                }
                //Reset values
                prev = c;
                currLength = 1;
            }
        }

        //Last char
        chars[compressedInd++] = prev;
        if(currLength > 1) {
            String digits = String.valueOf(currLength);
            for(char digit : digits.toCharArray()) chars[compressedInd++] = digit;
        }
        return compressedInd;
    }
}