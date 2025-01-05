class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Key intuition: permutation is same length, but has potentially different order of characters

        //Base case: Not possible if s1 larger than s2
        if(s1.length() > s2.length()) return false;

        //First K
        int[] s1Freqs = new int[26], s2Freqs = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            s1Freqs[s1.charAt(i) - 'a']++;
            s2Freqs[s2.charAt(i) - 'a']++;
        }

        //Sliding window
        for(int i = 0; i < s2.length() - s1.length(); i++) {
            //Evaluate current window for a match
            if(matches(s1Freqs, s2Freqs)) return true;

            //Shrink the sliding window
            s2Freqs[s2.charAt(i) - 'a']--;
            //Expand the sliding window
            s2Freqs[s2.charAt(s1.length() + i) - 'a']++;
        }
        return matches(s1Freqs, s2Freqs);
    }

    private boolean matches(int[] s1Freqs, int[] s2Freqs) {
        for(int i = 0; i < s1Freqs.length; i++) {
            if(s1Freqs[i] != s2Freqs[i]) return false;
        }
        return true;
    }
}