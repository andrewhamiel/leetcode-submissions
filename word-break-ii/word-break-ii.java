class Solution {
    private Set<String> words;
    private Map<String, List<List<String>>> memo = new HashMap();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        words = new HashSet(wordDict);
        
        dp(s);
        //Format result
        List<String> results = new ArrayList();
        for(List<String> words : memo.get(s)){
            StringBuilder sb = new StringBuilder();
            for(int i = words.size()-1; i >=0; i--){
                sb.append(" ");
                sb.append(words.get(i));
            }
            results.add(sb.toString().strip());
        }
        return results;
    }
    
    private List<List<String>> dp(String s){
        //Base case: empty string
        if(s.isEmpty()){
            List<List<String>> solutions = new ArrayList();
            solutions.add(new ArrayList());
            return solutions;
        }
        
        //Memoization
        if(memo.containsKey(s)) return memo.get(s);
        else{
            List<List<String>> solutions = new ArrayList();
            memo.put(s, solutions);
        }
        
        for(int i = 1; i <= s.length(); i++){
            String word = s.substring(0, i);
            if(words.contains(word)){
                List<List<String>> subsentences = dp(s.substring(i));
                for(List<String> subsentence : subsentences){
                    List<String> newSentence = new ArrayList(subsentence);
                    newSentence.add(word);
                    memo.get(s).add(newSentence);
                }
            }
        }
        return memo.get(s);
    }
}