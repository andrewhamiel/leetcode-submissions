class Solution {
    public boolean isMatch(String s, String p) {
        int sInd = 0, pInd = 0;
        int starSInd = -1, starPInd = -1;

        while(sInd < s.length()) {
            //1. p is '?' or chars match
            //2. p is '*'
            //3. chars do not match and prev '*' seen
            //4. chars do not match and no '*' seen
            if(pInd < p.length() && (p.charAt(pInd) == '?' || s.charAt(sInd) == p.charAt(pInd))) {
                sInd++;
                pInd++;
            }else if(pInd < p.length() && p.charAt(pInd) == '*') {
                //Store indeces of both when last star seen
                starSInd = sInd;
                starPInd = pInd;
                pInd++;
            }else if(starPInd >= 0) {
                //Backtrack to first char after last seen '*' and advance s by one character
                pInd = starPInd + 1;
                starSInd++;
                sInd = starSInd;
            }else return false;
        }

        //All remaining chars in p should be '*'
        for(int i = pInd; i < p.length(); i++) {
            if(p.charAt(i) != '*') return false;
        }
        
        return true;
    }
}