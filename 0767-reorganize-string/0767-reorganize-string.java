class Solution {
     public String reorganizeString(String s) {
         int[] count = new int[26];
         for(int i = 0; i < s.length(); i++){
             count[s.charAt(i) - 'a']++;
         }
         
         int maxOccur = 0, maxInd = 0;
         for(int i = 0; i < 26; i++){
             if(count[i] > maxOccur){
                 maxOccur = count[i];
                 maxInd = i;
             }
         }
         
         if(maxOccur > (s.length() + 1)/2) return "";
         
         char[] ans = new char[s.length()];
         int ind = 0;
         while(count[maxInd]-- > 0){
             ans[ind] = (char) (maxInd + 'a');
             ind+=2;
         }
         
         for(int i = 0; i < 26; i++){
             while(count[i]-- > 0){
                 if(ind >= s.length()) ind = 1;
                 ans[ind] = (char) (i + 'a');
                 ind+=2;
             }
         }
         return new String(ans);
     }
}