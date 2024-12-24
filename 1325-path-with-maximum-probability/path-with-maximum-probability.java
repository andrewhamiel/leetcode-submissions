class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> adj = new HashMap<>();
        //1. Build Graph
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double currProb = succProb[i];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, currProb));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, currProb));
        }

        double[] result = new double[n];
        result[start_node] = 1.0;

        PriorityQueue<Pair<Integer, Double>> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));
        maxHeap.add(new Pair<>(start_node, result[start_node]));

        while(!maxHeap.isEmpty()) {
            Pair<Integer, Double> currPair = maxHeap.poll();
            int currNode = currPair.getKey();
            double currProb = currPair.getValue();
            if(currNode == end_node) return currProb;

            for(Pair<Integer, Double> nextPair : adj.getOrDefault(currNode, new ArrayList<>())) {
                int nextNode = nextPair.getKey();
                double nextProb = nextPair.getValue();
                if(currProb * nextProb > result[nextNode]) {
                    result[nextNode] = currProb * nextProb;
                    maxHeap.add(new Pair<>(nextNode, result[nextNode]));
                }
            }
        }
        return 0.0;
    }
}