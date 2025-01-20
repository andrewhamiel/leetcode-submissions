class Solution {
    public int compress(char[] chars) {
        int ind = 0;
        char prev = chars[0];
        int currLength = 0;
        for(char c : chars) {
            if(c == prev) currLength++;
            else {
                chars[ind++] = prev;
                if(currLength > 1) {
                    String digit = String.valueOf(currLength);
                    for(int i = 0; i < digit.length(); i++) chars[ind++] = digit.charAt(i); 
                }                               
                prev = c;
                currLength = 1;
            }
        }

        //Last char
        chars[ind++] = prev;
        if(currLength > 1) {
            String digit = String.valueOf(currLength);
            for(int i = 0; i < digit.length(); i++) chars[ind++] = digit.charAt(i); 
        }      

        return ind;
    }
}