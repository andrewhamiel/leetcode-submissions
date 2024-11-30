class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        if(!words.contains(endWord)) return 0;
        q.add(beginWord);
        words.remove(beginWord);
        int ladderLength = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String curr = q.poll();
                if(curr.equals(endWord)) return ladderLength;

                for(String neighbor : getNeighbors(curr)) {
                    if(words.contains(neighbor)) {
                        words.remove(neighbor);
                        q.add(neighbor);
                    }
                }
            }
            ladderLength++;
        }
        return 0;
    }

    private Set<String> getNeighbors(String str) {
        Set<String> result = new HashSet<>();
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char prevChar = chars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != prevChar) chars[i] = c;
                result.add(new String(chars));
            }
            chars[i] = prevChar;
        }
        return result;
    }
}