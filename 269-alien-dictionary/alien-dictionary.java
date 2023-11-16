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

        //Step 1: Connect adjacent edges
        for(int wordInd = 0; wordInd < words.length - 1; wordInd++){
            String word1 = words[wordInd], word2 = words[wordInd + 1];
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                //Check to ensure not a substring
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
        for(Character key : deps.keySet()) if(deps.get(key) == 0) q.add(key);
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            for(Character nextChar : adj.get(curr)){
                deps.put(nextChar, deps.get(nextChar) - 1);
                if(deps.get(nextChar) == 0) q.add(nextChar);
            }
        }
        //Make sure all characters added
        return sb.length() != deps.size() ? "" : sb.toString();
    }
}