class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> adj = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double currProb = succProb[i];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, currProb));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, currProb));
        }

        if(!adj.containsKey(end_node)) return 0.0;

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        PriorityQueue<Pair<Integer, Double>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        maxHeap.add(new Pair<>(start_node, maxProb[start_node]));

        while(!maxHeap.isEmpty()) {
            Pair<Integer, Double> p = maxHeap.poll();
            int currNode = p.getKey();
            double currProb = p.getValue();
            if(currNode == end_node) return currProb;

            for(Pair<Integer, Double> nextPair : adj.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = nextPair.getKey();
                double nextProb = nextPair.getValue();
                
                if(currProb * nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = currProb * nextProb;
                    maxHeap.add(new Pair<>(nextNode, maxProb[nextNode]));
                }
            }
        }
        return 0.0;
    }
}