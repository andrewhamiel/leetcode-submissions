class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        // set to store forbidden words
        HashSet<String> set = new HashSet(forbidden);
        int maxLength = 0;
        for(String s:forbidden) maxLength = Math.max(s.length(),maxLength);
        int n = word.length();

        // going from right to left
        int l = n-1, r = n-1;
        // variable to store answer
        int max = 0;

        // everytime add a new character
        for( l=n-1;l>=0;l--) {
            // check for all the forbidden words starting from new character added
            for(int i=l;i<=Math.min(l+maxLength,r);i++) {
                // if it contains then move your pointer unless you reach a safe string
                if(set.contains(word.substring(l,i+1))){
                    r= i-1;
                    break;
                }
            }
            // calculate max at every step
            max = Math.max(r-l+1,max);
        }
        return max;
    }
}