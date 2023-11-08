class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length()==1) return 1;
        int[] array=new int[26];
        int left=0, maxCount=0, ans=0;

        for(int right = 0; right < s.length(); right++){
            array[s.charAt(right)-'A']++;
            maxCount=Math.max(array[s.charAt(right)-'A'],maxCount);
            if((right-left+1) - maxCount > k){
                array[s.charAt(left)-'A']--;
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}