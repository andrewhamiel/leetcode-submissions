class MedianFinder {
    PriorityQueue<Integer> smallest, largest;
    
    public MedianFinder() {
        smallest = new PriorityQueue<>(Collections.reverseOrder()); //max heap
        largest = new PriorityQueue<>(); //min heap
    }
    
    public void addNum(int num) {
        int size = smallest.size() + largest.size();
        if(size % 2 == 0){
            largest.add(num);
            smallest.add(largest.poll());
        }else{
            smallest.add(num);
            largest.add(smallest.poll());
        }
    }
    
    public double findMedian() {
        int size = smallest.size() + largest.size();
        if(size % 2 == 0){
            return (double)(smallest.peek() + largest.peek())/2;
        }else{
            return (double)smallest.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */