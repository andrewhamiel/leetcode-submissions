class AutocompleteSystem {
    class TrieNode{
        TrieNode[] children = new TrieNode[27];
        Map<String, Integer> map = new HashMap(); //At each TrieNode, count string/counts of each
    }
    
    private StringBuilder sb;
    private TrieNode root;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(int i = 0; i < sentences.length; i++)
            add(sentences[i], times[i]);
    }
    
    private void add(String sentence, int count){
        TrieNode node = root;
        for(Character ch : sentence.toCharArray()){
            int ind = ch == ' ' ? 26 : ch - 'a';
            if(node.children[ind] == null) node.children[ind] = new TrieNode();
            node = node.children[ind];
            node.map.put(sentence, node.map.getOrDefault(sentence, 0) + count);
        }       
    }
    
    public List<String> input(char c) {
        List<String> result = new ArrayList();
        if(c == '#'){
            add(sb.toString(), 1);
            sb = new StringBuilder();
            return result;
        }
        
        TrieNode node = root;
        sb.append(c);
        
        for(Character ch : sb.toString().toCharArray()){
            int ind = ch == ' ' ? 26 : ch - 'a';
            if(node.children[ind] == null) return result;
            node = node.children[ind];
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue()
                                                                          ? a.getKey().compareTo(b.getKey())
                                                                          : b.getValue() - a.getValue());
        
        for(Map.Entry<String, Integer> entry : node.map.entrySet()) pq.offer(entry);
        
        int count = 3;
        while(!pq.isEmpty() && count-- > 0){
            result.add(pq.poll().getKey());
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */