class Solution {
    public void lps(String needle, int[] pi){
        int j=0;
        for(int i=1; i<needle.length() ;i++){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
                pi[i]= j;
            }else{
                if(j!=0){
                    j = pi[j-1];
                    i--;
                }else{
                    pi[i] = 0;
                }
            }
        }

    }
    public int strStr(String haystack, String needle) {
        int j=0;
        int[] pi = new int[needle.length()];
        lps(needle, pi);
        for(int i=0 ; i<haystack.length() ;i++){
            if(needle.charAt(j)==haystack.charAt(i)){
                j++;
                if(j==needle.length()){
                    return i-j+1;
                }
            }else{
                if(j!=0){
                    j=pi[j-1];
                    i--;
                }
            }
        }
        return -1;
    }
}