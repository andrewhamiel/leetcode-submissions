class MovingAverage {
    private Queue<Integer> q = new ArrayDeque<>();
    private int size = 0;
    private double sum = 0.0;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        q.add(val);
        sum+= val;
        if(q.size() > size) sum-= q.poll();
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */