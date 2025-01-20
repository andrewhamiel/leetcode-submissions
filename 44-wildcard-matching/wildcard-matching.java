class Solution {
    public boolean isMatch(String s, String p) {
        int sInd = 0, pInd = 0;
        int starSInd = -1, starPInd = -1;
        while(sInd < s.length()) {
            //1. p is '?' or characters match
            //2. p is '*'
            //3. chars do not match but prev '*' seen
            //4. chars do not match and no prev '*'
            if(pInd < p.length() && (p.charAt(pInd) == '?' || s.charAt(sInd) == p.charAt(pInd))) {
                sInd++;
                pInd++;
            }else if(pInd < p.length() && p.charAt(pInd) == '*') {
                //Start by advancing 0
                starSInd = sInd;
                pInd++;
                starPInd = pInd;
            }else if(starPInd >= 0) {
                pInd = starPInd;
                starSInd++; //Increment by 1
                sInd = starSInd;
            }else return false;
        }
        
        //Remaining chars should all be '*'
        for(int i = pInd; i < p.length(); i++) if(p.charAt(i) != '*') {
            return false;
        }
        return true;
    }
}