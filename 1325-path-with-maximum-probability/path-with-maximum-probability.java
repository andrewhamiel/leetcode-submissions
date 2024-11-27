class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, prob));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, prob));
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        PriorityQueue<Pair<Integer, Double>> maxHeap = new PriorityQueue<>((a, b) -> -Double.compare(a.getValue(), b.getValue()));
        maxHeap.add(new Pair<>(start_node, maxProb[start_node]));
        while(!maxHeap.isEmpty()) {
            Pair<Integer, Double> p = maxHeap.poll();
            int currNode = p.getKey();
            double currProb = p.getValue();
            if(currNode == end_node) return currProb;

            for(Pair<Integer, Double> nextPair : graph.getOrDefault(currNode, new ArrayList<>())) {
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