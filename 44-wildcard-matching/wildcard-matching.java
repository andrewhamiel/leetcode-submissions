class Solution {
    public boolean isMatch(String s, String p) {
        int sInd = 0, pInd = 0;
        int starPInd = -1, starSInd = -1;
        
        while(sInd < s.length()) {
            //1. char p is '?' or characters match
            //2. char p is '*'
            //3. chars do not match and previous '*' seen
            //4. chars do not match and no '*' seen
            if(pInd < p.length() && (p.charAt(pInd) == '?' || s.charAt(sInd) == p.charAt(pInd))) {
                sInd++;
                pInd++;
            }else if(pInd < p.length() && p.charAt(pInd) == '*') {
                //Advance 0 characters to start
                starPInd = pInd;
                starSInd = sInd;
                pInd++;
            }else if(starPInd >= 0) {
                //Backtrack to prev '*' seen and advance s one char
                pInd = starPInd + 1;
                starSInd++; //Advance s one char
                sInd = starSInd;
            }else return false;
        }

        //All remaining chars should be '*'
        for(int i = pInd; i < p.length(); i++) {
            if(p.charAt(i) != '*') return false;
        }
        return true;
    }
}