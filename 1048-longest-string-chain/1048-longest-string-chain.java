class Solution {
    /*
    * Tabulation approach
    * Runtime complexity: O(nlog(n) + n(L^2))
    * O(nlog(n)): Sorting array
    * O(n(L^2)): Iterate through each word n, first L from iterating each character, second L from predecessor creation
    */
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap();
        
        //Sort by ascending length
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        
        int longestChain = 1;
        for(String word : words){
            int currLength = 1;
            for(int i = 0; i < word.length(); i++){
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                int predecessorLength = dp.getOrDefault(predecessor.toString(), 0);
                currLength = Math.max(currLength, predecessorLength + 1);
            }
            dp.put(word, currLength);
            longestChain = Math.max(longestChain, currLength);
        }
        return longestChain;
    }
}