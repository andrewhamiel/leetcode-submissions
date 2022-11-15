class SORTracker {
    PriorityQueue<String> minHeap, maxHeap;

    public SORTracker() {
        maxHeap = new PriorityQueue<String>(Collections.reverseOrder());
        minHeap = new PriorityQueue<String>();
    }
    
    public void add(String name, int score) {
        String s = String.format("%05d%s", 100000 - score, name);
        if(!maxHeap.isEmpty() && maxHeap.peek().compareTo(s) > 0){
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(s);
        }else minHeap.offer(s);
    }
    
    public String get() {
        String s = minHeap.poll();
        maxHeap.offer(s);
        return s.substring(5);
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */