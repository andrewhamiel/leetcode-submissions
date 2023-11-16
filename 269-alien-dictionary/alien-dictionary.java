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

        //Step 1: Find adjacencies and dependencies
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i], word2 = words[i + 1];
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                //Make sure word2 not substring of word1
                if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
                if(word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    deps.put(word2.charAt(j), deps.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        //Step 2: BFS
        Queue<Character> q = new LinkedList<>();
        //Seed with characters that do not have dependencies
        for(char c : deps.keySet()) if(deps.get(c) == 0) q.add(c);
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            for(Character nextChar : adj.get(curr)){
                deps.put(nextChar, deps.get(nextChar) - 1);
                if(deps.get(nextChar) == 0) q.add(nextChar);
            }
        }
        //Step 3: Validate sb length same as number of characters
        if(sb.length() != deps.size()) return "";
        return sb.toString();
    }
}