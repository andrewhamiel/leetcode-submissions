class SORTracker {
    PriorityQueue<String> minHeap, maxHeap;
    
    public SORTracker() {
        minHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    
    //T: O(log(n))
    //S: O(n)
    public void add(String name, int score) {
    	String s = String.format("%05d%s", 100000 - score, name);
        if (!minHeap.isEmpty() && minHeap.peek().compareTo(s) > 0) {
        	maxHeap.offer(minHeap.poll());
        	minHeap.offer(s);
        } else maxHeap.offer(s);
    }
    
    //T: O(log(n))
    //S: O(n)
    public String get() {
        String s = maxHeap.poll();
        minHeap.offer(s);
        return s.substring(5);
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */