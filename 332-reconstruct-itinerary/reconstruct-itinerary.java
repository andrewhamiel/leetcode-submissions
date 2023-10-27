class Solution {

  public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        //1. Build Graph
        for(int i=0; i<tickets.size(); i++){
            map.putIfAbsent(tickets.get(i).get(0), new PriorityQueue<String>());
            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        } 
        //2. DFS
        Deque<String> deq = new ArrayDeque<>();
        dfs("JFK", map, deq);

        return new ArrayList<>(deq);
    }

    private void dfs(String s, Map<String, PriorityQueue<String>> map, Deque<String> list){
        PriorityQueue<String> pq = map.get(s);
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll(), map, list);
        }
        list.addFirst(s);
    }
}

        
