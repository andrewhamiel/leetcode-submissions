class Solution {
    public String alienOrder(String[] words) {
        //Step 0: Build adjacency graph
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> deps = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new ArrayList<>());
                deps.putIfAbsent(c, 0);
            }
        }

        //Step 1: Connect components
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i], word2 = words[i + 1];
            //Ensure this is not a substring
            if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
            for(int wordInd = 0; wordInd < Math.min(word1.length(), word2.length()); wordInd++){
                char c1 = word1.charAt(wordInd), c2 = word2.charAt(wordInd);
                if(c1 != c2){
                    adj.get(c1).add(c2);
                    deps.put(c2, deps.get(c2) + 1);
                    break;
                }
            }
        }

        //Step 3: BFS
        Queue<Character> q = new LinkedList<>();
        for(char c : deps.keySet()) if(deps.get(c) == 0) q.add(c);
        StringBuilder result = new StringBuilder();

        while(!q.isEmpty()){
            char curr = q.poll();
            result.append(curr);

            for(char nextChar : adj.get(curr)){
                deps.put(nextChar, deps.get(nextChar) - 1);
                if(deps.get(nextChar) == 0) q.add(nextChar);
            }
        }

        //Step 4: Validate all characters have been collected
        return result.length() == deps.size() ? result.toString() : "";
    }
}