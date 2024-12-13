class Solution {
    public String alienOrder(String[] words) {
        //1. Build graph
        Map<Character, GNode> adj = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                adj.putIfAbsent(c, new GNode());
            }
        }

        //2. Connect components
        for(int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];
            if(word1.length() > word2.length() && word1.startsWith(word2)) return ""; //prevent substrings
            for(int wordInd = 0; wordInd < Math.min(word1.length(), word2.length()); wordInd++) {
                char c1 = word1.charAt(wordInd), c2 = word2.charAt(wordInd);
                if(c1 != c2) {
                    adj.get(c1).nextChars.add(c2);
                    adj.get(c2).dependencies++;
                    break;
                }
            }
        }

        //3. Topological Sort
        Queue<Character> q = new LinkedList<>();
        for(char key : adj.keySet()) if(adj.get(key).dependencies == 0) q.add(key);

        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()) {
            char currChar = q.poll();
            result.append(currChar);

            for(char nextChar : adj.get(currChar).nextChars) {
                adj.get(nextChar).dependencies--;
                if(adj.get(nextChar).dependencies == 0) q.add(nextChar);
            }
        }
        //4. Make sure all characters included in result
        return result.length() == adj.size() ? result.toString() : "";
    }

    class GNode {
        int dependencies = 0;
        List<Character> nextChars = new ArrayList<>();
    }
}