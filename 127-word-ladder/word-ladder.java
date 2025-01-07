class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int wordLength = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String currWord = q.poll();
                if(currWord.equals(endWord)) return wordLength;

                for(String nextWord : getNeighbors(currWord)) {
                    if(words.contains(nextWord)) {
                        words.remove(nextWord);
                        q.add(nextWord);
                    }
                }
            }
            wordLength++;
        }
        return 0;
    }

    private Set<String> getNeighbors(String currWord) {
        Set<String> result = new HashSet<>();
        char[] arr = currWord.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            char prevLetter = arr[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != prevLetter) {
                    arr[i] = c;
                    result.add(new String(arr));
                }
            }
            arr[i] = prevLetter;
        }
        return result;
    }
}