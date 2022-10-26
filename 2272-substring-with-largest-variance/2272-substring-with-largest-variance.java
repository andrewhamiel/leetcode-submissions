class Solution {
    public int largestVariance(String s) {
        int[] freq = new int[26];
        for(Character ch : s.toCharArray()) freq[ch - 'a']++;
        
        int max = 0;
        for(int charA = 0; charA < 26; charA++){
            for(int charB = 0; charB < 26; charB++){
                int remainA = freq[charA], remainB = freq[charB];
                if(charA == charB || remainA == 0 || remainB == 0) continue;
                int aFreq = 0, bFreq = 0;
                for(int k = 0; k < s.length(); k++){
                    int currChar = s.charAt(k) - 'a';
                    if(currChar == charB) bFreq++;
                    if(currChar == charA){
                        remainA--;
                        aFreq++;
                    }
                    if(aFreq > 0) max = Math.max(max, bFreq - aFreq);
                    if(remainA >= 1 && bFreq < aFreq){
                        aFreq = 0;
                        bFreq = 0;
                    }
                }
            }
        }
        return max;
    }
}