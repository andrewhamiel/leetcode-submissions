class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        int sInd = 0, tInd = 0;
        while(tInd < t.length() && sInd < s.length()) {
            if(s.charAt(sInd) == t.charAt(tInd)) {
                sInd++;
                tInd++;
            }else tInd++;
        }
        return sInd == s.length();
    }
}