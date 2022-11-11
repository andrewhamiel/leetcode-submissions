class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        int count = 1; // count the number of words transformed
        queue.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            // for all words this round
            for (int i = 0; i < size; i++) {
                char[] currentWord = queue.poll().toCharArray();
                // traverse current word
                for (int j = 0; j < currentWord.length; j++) {
                    char currentWordLetter = currentWord[j];
                    // change one letter at a time
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentWord[j] = c;
                        String nextWord = new String(currentWord);
                        // when nextWord is in the set
                        if(wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return count + 1;
                            }
                            queue.add(nextWord);
                            wordSet.remove(nextWord);
                        } // end of 'if'
                    } // end of 'c' loop
                    currentWord[j] = currentWordLetter; // have to undo for next change of letter
                } // end of 'j' loop
            } // end of 'i' char loop
            count++; // this round ends with one letter changed
        } // end of 'while'
        return 0;
    }
}