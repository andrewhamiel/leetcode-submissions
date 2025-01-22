class MovingAverage {
    private double sum = 0.0;
    private int size = 0;
    private Queue<Integer> q = new LinkedList<>();

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        sum+= val;
        if(q.size() == size)sum-= q.poll();
        q.add(val);
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */