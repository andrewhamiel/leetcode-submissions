class Solution {
    public String alienOrder(String[] words) {
        Map<Character, GNode> adj = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                adj.putIfAbsent(c, new GNode());
            }
        }

        for(int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];
            if(word1.length() > word2.length() && word1.startsWith(word2)) return ""; //Prevent prefixes
            for(int wordInd = 0; wordInd < Math.min(word1.length(), word2.length()); wordInd++) {
                char c1 = word1.charAt(wordInd), c2 = word2.charAt(wordInd);
                if(c1 != c2) {
                    adj.get(c1).nextChars.add(c2);
                    adj.get(c2).dependencies++;
                    break;
                }
            }
        }

        Queue<Character> noDeps = new LinkedList<>();
        for(char key : adj.keySet()) if(adj.get(key).dependencies == 0) noDeps.add(key);

        StringBuilder result = new StringBuilder();

        while(!noDeps.isEmpty()) {
            char curr = noDeps.poll();
            result.append(curr);

            for(char nextChar : adj.get(curr).nextChars) {
                adj.get(nextChar).dependencies--;
                if(adj.get(nextChar).dependencies == 0) noDeps.add(nextChar);
            }
        }

        return result.length() == adj.size() ? result.toString() : "";
    }

    class GNode {
        int dependencies = 0;
        List<Character> nextChars = new ArrayList<>();
    }
}