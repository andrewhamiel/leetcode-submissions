class MovingAverage {

    Queue<Integer> stream;
    int size;
    long sum;

    public MovingAverage(int size) {
        sum = 0;
        this.size = size;
        stream = new LinkedList<>();
    }
    
    public double next(int val) {
        if(stream.size() == size){
            sum-= stream.poll();
        }
        sum+= val;
        stream.add(val);
        return (double) sum/stream.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */