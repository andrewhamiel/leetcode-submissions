class Solution {
    //Greedy
    //Time: O(n)
    //Space: O(n)
    public String reorganizeString(String s) {
        //1: count occurrences: O(n)
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        
        //Find max occurring character: O(1)
        int maxOccur = 0, maxInd = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] > maxOccur){
                maxOccur = count[i];
                maxInd = i;
            }
        }
        
        //If occurs more than 50% of time, not possible to rearrange
        if(maxOccur > (s.length() + 1)/2) return "";
        
        //Place largest occurring char: O(maxOccurrences <= O(n/2))
        int ind = 0;
        char[] ans = new char[s.length()];
        while(count[maxInd]-- > 0){
            ans[ind] = (char)(maxInd + 'a');
            ind+=2;
        }
        
        //Place other characters: O(n - maxOccurrences >= n/2)
        for(int i = 0; i < 26; i++){
            while(count[i]-- > 0){
                //If out of bounds, reset ind
                if(ind >= s.length()) ind = 1;
                ans[ind] = (char)(i + 'a');
                ind+=2;
            }
        }
        
        return new String(ans);
    }
}