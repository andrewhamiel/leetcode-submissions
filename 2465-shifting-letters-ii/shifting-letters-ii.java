class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        //1. Cumulative sum of shifts
        int[] diffArray = new int[s.length()];

        //2. Process shifts
        for(int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            //3. Forward or backward
            if(direction == 1) {
                //Forward
                diffArray[start]++;
                if(end + 1 < s.length()) diffArray[end + 1]--;
            }else {
                //Backward
                diffArray[start]--;
                if(end + 1 < s.length()) diffArray[end + 1]++;
            }
        }

        //4. Strings immutable in java, so convert to char array so we can replace characters
        char[] result = s.toCharArray();
        int shiftCount = 0;

        //5. Apply shifts 
        for(int i = 0; i < result.length; i++) {
            //6. Update shift count. Wrap around to keep non-negative
            shiftCount = (shiftCount + diffArray[i]) % 26;
            if(shiftCount < 0) shiftCount+= 26;

            //7. Shift character to appropriate letter
            int shiftedCharInd = (result[i] - 'a' + shiftCount) % 26;
            char shiftedChar = (char) (shiftedCharInd + 'a');
            result[i] = shiftedChar;
        }

        //8. Convert back to string
        return new String(result);
    }
}