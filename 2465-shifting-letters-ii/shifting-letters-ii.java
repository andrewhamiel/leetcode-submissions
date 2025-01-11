class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diffArray = new int[s.length()];

        //1. Process shifts
        for(int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            //2. Forward or backward
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

        //3. Strings immutable, convert result to char array
        char[] result = s.toCharArray(); 
        int shiftCount = 0;

        //4. Apply Shifts
        for(int i = 0; i < result.length; i++) {
            //5. Shift diff[i] characters, wrap back around if negative
            shiftCount = (shiftCount + diffArray[i]) % 26;
            if(shiftCount < 0) shiftCount+= 26; 

            //6. Shift s[i] for new character?
            int shiftedLetterInd = (result[i] - 'a' + shiftCount) % 26;
            char shiftedChar = (char) (shiftedLetterInd + 'a');
            result[i] = shiftedChar;
        }
        
        //7. Convert back to string
        return new String(result);
    }
}