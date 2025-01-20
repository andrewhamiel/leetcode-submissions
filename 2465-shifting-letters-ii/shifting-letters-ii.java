class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        //1. Cumulative Sum
        int[] diffArray = new int[s.length()];

        //2. Process shifts
        for(int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            //3. Forward or backward
            if(direction == 1) {
                diffArray[start]++;
                if(end + 1 < s.length()) diffArray[end + 1]--;
            }else {
                diffArray[start]--;
                if(end + 1 < s.length()) diffArray[end + 1]++;
            }
        }

        //4. Strings immutable in java, so convert to character array to shift chars
        char[] result = s.toCharArray();
        int currShifts = 0;

        for(int i = 0; i < s.length(); i++) {
            //5. Calculate shift
            currShifts = (currShifts + diffArray[i]) % 26;
            if(currShifts < 0) currShifts+= 26;

            //6. Shift character in array
            int shiftInd = (result[i] - 'a' + currShifts) % 26;
            result[i] = (char)(shiftInd + 'a');
        }
        //7. Convert back to string
        return new String(result);
    }
}