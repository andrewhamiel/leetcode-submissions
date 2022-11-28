class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> answer = new ArrayList();
        answer.add(new ArrayList());
        answer.add(new ArrayList());
        Map<Integer, Integer> losses = new HashMap();
        for(int[] match : matches){
            losses.put(match[1], losses.getOrDefault(match[1], 0) + 1);
        }
        Set<Integer> seen = new HashSet();
        for(int[] match : matches) {
            if(losses.containsKey(match[0]) && losses.get(match[0]) == 1 && !seen.contains(match[0])) {
                answer.get(1).add(match[0]);
                seen.add(match[0]);
            }
            else if(!losses.containsKey(match[0]) && !seen.contains(match[0])){
                answer.get(0).add(match[0]);
                seen.add(match[0]);
            } 
            if(losses.containsKey(match[1]) && losses.get(match[1]) == 1 && !seen.contains(match[1])){
                answer.get(1).add(match[1]);
                seen.add(match[1]);
            } 
        }
        Collections.sort(answer.get(0));
        Collections.sort(answer.get(1));
        return answer;
    }
}