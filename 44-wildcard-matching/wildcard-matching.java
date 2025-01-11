class Solution {
    public boolean isMatch(String s, String p) {
        int sInd = 0, pInd = 0;
        int starInd = -1, starSBeginInd = -1;

        while(sInd < s.length()) {
            //1. char p == '?' or characters equal
            //2. char p == '*'
            //3. chars not equal and '*' seen previously
            //4. chars not equal and no '*' seen
            if(pInd < p.length() && (p.charAt(pInd) == '?' || s.charAt(sInd) == p.charAt(pInd))) {
                sInd++;
                pInd++;
            }else if(pInd < p.length() && p.charAt(pInd) == '*') {
                //Advance 0 characters to start
                starInd = pInd;
                starSBeginInd = sInd;
                pInd++;
            }else if(starInd >= 0) {
                //Backtrack to last seen '*' and advance one character
                pInd = starInd + 1;
                starSBeginInd++; //Advance one character
                sInd = starSBeginInd;
            }else return false;
        }

        //All characters remaining should be '*'
        for(int i = pInd; i < p.length(); i++) {
            if(p.charAt(i) != '*') return false;
        }
        return true;
    }
}