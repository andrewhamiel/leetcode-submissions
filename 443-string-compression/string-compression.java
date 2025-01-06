class Solution {
    public int compress(char[] chars) {
        char prev = chars[0];
        int currLength = 1, ind = 0;
        for(int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if(c == prev) currLength++;
            else {
                //Replace in array
                chars[ind++] = prev;
                if(currLength > 1) {
                    String digits = String.valueOf(currLength);
                    for(int digit = 0; digit < digits.length(); digit++) chars[ind++] = digits.charAt(digit);
                }
                //Reset values
                prev = c;
                currLength = 1;
            }
        }

        //Final character
        chars[ind++] = prev;
        if(currLength > 1) {
            String digits = String.valueOf(currLength);
            for(int digit = 0; digit < digits.length(); digit++) chars[ind++] = digits.charAt(digit);
        }
        
        return ind;
    }
}