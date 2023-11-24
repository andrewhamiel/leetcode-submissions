class Solution {
    public String alienOrder(String[] words) {
        //Step 0: Initialize adjacency graphs
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> dependencies = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new ArrayList<>());
                dependencies.putIfAbsent(c, 0);
            }
        }

        //Step 1: Connect components
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i], word2 = words[i + 1];
            for(int wordInd = 0; wordInd < Math.min(word1.length(), word2.length()); wordInd++){
                //Ensure not a substring
                if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
                if(word1.charAt(wordInd) != word2.charAt(wordInd)){
                    adj.get(word1.charAt(wordInd)).add(word2.charAt(wordInd));
                    dependencies.put(word2.charAt(wordInd), dependencies.get(word2.charAt(wordInd)) + 1);
                    break;
                }
            }
        }

        //Step 2: BFS
        Queue<Character> noDeps = new LinkedList<>();
        for(char c : dependencies.keySet()) if(dependencies.get(c) == 0) noDeps.add(c);
        StringBuilder result = new StringBuilder();

        while(!noDeps.isEmpty()){
            char c = noDeps.poll();
            result.append(c);
            for(char dep : adj.get(c)){
                dependencies.put(dep, dependencies.get(dep) - 1);
                if(dependencies.get(dep) == 0) noDeps.add(dep);
            }
        }
        //Step 3: Validate all characters collected
        return result.length() == dependencies.size() ? result.toString() : "";
    }
}