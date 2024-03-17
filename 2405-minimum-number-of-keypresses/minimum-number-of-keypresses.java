class Solution {
    public int minimumKeypresses(String s) {
        int result = 0;
        Integer[] count = new Integer[26];
        Arrays.fill(count, 0);
        //O(n) loop
        for(int i=0; i<s.length(); i++) 
            count[s.charAt(i)-'a']++;
        
        Arrays.sort(count, (a,b)->b-a);
        
        //O(1) loop
        for(int i=0; i<26; i++) {
            //Add num keystrokes depending on order in keypad
            if(i<9) result += count[i];
            else if(i<18) result += 2*count[i];
            else result += 3*count[i];
        }
        return result;
    }
}