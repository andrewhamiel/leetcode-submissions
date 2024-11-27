class Solution {
    public String alienOrder(String[] words) {
        //1. Build adjacencies 
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> deps = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                deps.putIfAbsent(c, 0);
            }
        }

        //2. Connect components 
        for(int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];
            if(word1.length() > word2.length() && word1.startsWith(word2)) return ""; //prevent substrings
            for(int wordInd = 0; wordInd < Math.min(word1.length(), word2.length()); wordInd++) {
                char c1 = word1.charAt(wordInd), c2 = word2.charAt(wordInd);
                if(c1 != c2) {
                    adj.get(c1).add(c2);
                    deps.put(c2, deps.get(c2) + 1);
                    break;
                }
            }
        }

        //3. Find vertices with no deps, topological sort 
        Queue<Character> q = new LinkedList<>();
        for(char c : deps.keySet()) if(deps.get(c) == 0) q.add(c);

        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()) {
            char c = q.poll();
            result.append(c);
            for(char nextChar : adj.get(c)) {
                deps.put(nextChar, deps.get(nextChar) - 1);
                if(deps.get(nextChar) == 0) q.add(nextChar);
            }
        }

        //4. Make sure all characters added 
        return result.length() == deps.size() ? result.toString() : "";
    }
}