class MedianFinder {
    private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int size = left.size() + right.size();
        if(size % 2 == 0) {
            right.add(num);
            left.add(right.poll());
        }else {
            left.add(num);
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        int size = left.size() + right.size();
        if(size % 2 == 0) return (double) (left.peek() + right.peek())/2;
        else return (double) left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */