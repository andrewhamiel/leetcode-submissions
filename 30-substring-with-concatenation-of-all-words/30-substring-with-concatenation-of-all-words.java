class Solution {
    private int n, numWords, wordLength, maxSubstringLength;
    private Map<String, Integer> wordCount = new HashMap();
    private List<Integer> ans = new ArrayList();
    
    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        numWords = words.length;
        wordLength = words[0].length();
        maxSubstringLength = numWords * wordLength;
        
        //Populate wordCount map
        for(String word : words)
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        
        //Iterate up to wordLength characters in case of offset
        for(int i = 0; i < wordLength; i++)
            slidingWindow(i, s);
        return ans;
    }
    
    private void slidingWindow(int left, String s){
        Map<String, Integer> wordsSeen = new HashMap();
        int wordsUsed = 0;
        boolean excessWord = false;
        
        for(int right = left; right <= n - wordLength; right+=wordLength){
            String sub = s.substring(right, right + wordLength);
            //Case 1: mismatching word, reset window and clear
            if(!wordCount.containsKey(sub)){
                wordsSeen.clear();
                left = right + wordLength;
                excessWord = false;
                wordsUsed = 0;
            }else{
                //Case 2: Max window size or excess word
                while(right - left == maxSubstringLength || excessWord){
                    String leftmostWord = s.substring(left, left + wordLength);
                    left+=wordLength;
                    wordsSeen.put(leftmostWord, wordsSeen.get(leftmostWord) - 1);
                    //Case 2a. Found an excess word
                    if(wordsSeen.get(leftmostWord) >= wordCount.get(leftmostWord)) excessWord = false;
                    //Case 2b. We actually needed this one, decrement words used
                    else wordsUsed--;
                }
                
                //Add to wordsSeen map
                wordsSeen.put(sub, wordsSeen.getOrDefault(sub, 0) + 1);
                //Make sure this doesn't go past word limit
                if(wordsSeen.get(sub) <= wordCount.get(sub)) wordsUsed++;
                else excessWord = true;
                
                //Case 3: valid substring found, add to ans
                if(wordsUsed == numWords && !excessWord) ans.add(left);
            }
        }
    }
}