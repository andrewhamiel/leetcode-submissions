class Solution {
    public boolean isMatch(String s, String p) {
        int sInd = 0, pInd = 0;
        int starInd = -1, starBeginSInd = -1;

        while(sInd < s.length()) {
            //1. if p char is '?' or characters equal
            //2. p char is '*'
            //3. Not equal and Prev start seen
            //4. Not equal and no star seen
            if(pInd < p.length() && (p.charAt(pInd) == '?' || s.charAt(sInd) == p.charAt(pInd))) {
                sInd++;
                pInd++;
            }else if(pInd < p.length() && p.charAt(pInd) == '*') {
                starInd = pInd;
                starBeginSInd = sInd;
                pInd++;
            }else if(starInd >= 0) {
                //Backtrack when '*' matches one more character
                pInd = starInd + 1;
                starBeginSInd++; //start one character later
                sInd = starBeginSInd;
            }else return false;
        }

        //remaining chars all must be '*'
        for(int i = pInd; i < p.length(); i++) {
            if(p.charAt(i) != '*') return false;
        }
        return true;
    }
}