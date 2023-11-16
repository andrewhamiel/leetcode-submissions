class Solution {
    public String alienOrder(String[] words) {
        //Step 0: Build frequencies and adjacency graph
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> freq = new HashMap<>();
        for(String word : words){
            for(Character c : word.toCharArray()){
                adj.put(c, new ArrayList<>());
                freq.put(c, 0);
            }
        }
        //Step 1: Find relations between characters, validate correctness
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i], word2 = words[i+1];
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                //check to se word2 not substring of word1
                if(word1.length() > word2.length() && word1.startsWith(word2)) return "";
                if(word1.charAt(j) != word2.charAt(j)){
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    freq.put(word2.charAt(j), freq.get(word2.charAt(j)) + 1);
                    break;   
                }
            }
        }
        //Step 2: BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for(Character key : freq.keySet()) if(freq.get(key) == 0) q.add(key);
        while(!q.isEmpty()){
            Character curr = q.poll();
            sb.append(curr);
            List<Character> rels = adj.get(curr);
            for(Character nextChar : rels){
                freq.put(nextChar, freq.get(nextChar) - 1);
                if(freq.get(nextChar) == 0) q.add(nextChar);
            }
        }
        //Step 3: Validate each character in returning order
        if(sb.length() != freq.size()) return "";
        return sb.toString();

        
    }
}