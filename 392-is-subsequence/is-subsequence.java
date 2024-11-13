class Solution {
    public boolean isSubsequence(String s, String t) {
        int sInd = 0, tInd = 0;
        while(sInd < s.length() && tInd < t.length()) {
            if(s.charAt(sInd) == t.charAt(tInd)) sInd++;
            tInd++;
        }
        
        return sInd == s.length();
    }
}