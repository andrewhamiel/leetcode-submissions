class Solution {
    private Map<String, Integer> wordCount = new HashMap();
    private int n, wordLength, maxSubstringLength, numWords;
    private List<Integer> answer = new ArrayList();
    
    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        numWords = words.length;
        wordLength = words[0].length();   
        maxSubstringLength = wordLength * numWords;
        
        for(String word : words) 
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        
        //Iterate up to wordLength starting characters in case of offset
        for(int i = 0; i < wordLength; i++)
            slidingWindow(i, s);
        return answer;
    }
    
    private void slidingWindow(int left, String s){
        Map<String, Integer> wordsSeen = new HashMap();
        int wordsUsed = 0;
        boolean excessWord = false;
        
        for(int right = left; right <= n - wordLength; right+=wordLength){
            String sub = s.substring(right, right + wordLength);
            //Case 1: Word not in array, clear and shift left wordLength chars
            if(!wordCount.containsKey(sub)){
                wordsSeen.clear();
                wordsUsed = 0;
                excessWord = false;   
                left = right + wordLength;
            }else{
                //Case 2: Max Window Size or excess word present
                while(right-left == maxSubstringLength || excessWord){
                    String leftmostWord = s.substring(left, left+wordLength);
                    left+=wordLength;
                    wordsSeen.put(leftmostWord, wordsSeen.get(leftmostWord) -1);
                    //Case 2a. excess word removed
                    if(wordsSeen.get(leftmostWord) >= wordCount.get(leftmostWord)) excessWord = false;
                    //Case 2b. word needed, remove from words used
                    else wordsUsed--;
                }
                
                //Add occurrence of word seen
                wordsSeen.put(sub, wordsSeen.getOrDefault(sub, 0) + 1);
                //If not past limit increment wordsUsed
                if(wordsSeen.get(sub) <= wordCount.get(sub)) wordsUsed++;
                //Otherwise flag excessWord
                else excessWord = true;
                
                //Case 3: Have reached conditions for substring
                if(wordsUsed == numWords && !excessWord) answer.add(left);
            }
        }
    }      
}