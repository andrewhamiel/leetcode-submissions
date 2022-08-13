class Solution {
    private Map<String, Integer> wordCount = new HashMap();
    private int n, wordLength, substringSize, k;
    
    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;
        
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) 
            slidingWindow(i, s, answer);        
        
        return answer;
    }
    
    private void slidingWindow(int left, String s, List<Integer> answer) {
        Map<String, Integer> wordsFound = new HashMap();
        int wordsUsed = 0;
        boolean excessWord = false;
        
        // Do the same iteration pattern as the previous approach - iterate
        // word_length at a time, and at each iteration we focus on one word
        for (int right = left; right <= n - wordLength; right += wordLength) {
            
            String sub = s.substring(right, right + wordLength);
            if (!wordCount.containsKey(sub)) {
                // Mismatched word - reset the window
                wordsFound.clear();
                wordsUsed = 0;
                excessWord = false;
                left = right + wordLength;
            } else {
                // If we reached max window size or have an excess word
                while (right - left == substringSize || excessWord) {
                    String leftmostWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    wordsFound.put(leftmostWord, wordsFound.get(leftmostWord) - 1);
                    // This word was an excess word
                    if (wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord)) excessWord = false;
                    // Otherwise we actually needed it
                    else  wordsUsed--;
                }
                
                // Keep track of how many times this word occurs in the window
                wordsFound.put(sub, wordsFound.getOrDefault(sub, 0) + 1);
                if (wordsFound.get(sub) <= wordCount.get(sub)) wordsUsed++;
                // Found too many instances already
                else excessWord = true;
                
                // Found a valid substring
                if (wordsUsed == k && !excessWord) answer.add(left);
            }
        }
    }        
}