class MaxStack {
    Stack<int[]> top = new Stack();
    PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
    int count = 0;
    Set<Integer> removed = new HashSet();

    public MaxStack() {
        
    }
    
    public void push(int x) {
        heap.add(new int[]{x, count});
        top.push(new int[]{x, count});
        count++;
    }
    
    public int pop() {
        while(removed.contains(top.peek()[1])) top.pop();
        int[] arr = top.pop();
        removed.add(arr[1]);
        return arr[0];
    }
    
    public int top() {
        while(removed.contains(top.peek()[1])) top.pop();
        return top.peek()[0];
    }
    
    public int peekMax() {
        while(removed.contains(heap.peek()[1])) heap.poll();
        return heap.peek()[0];
    }
    
    public int popMax() {
        while(removed.contains(heap.peek()[1])) heap.poll();
        int[] arr = heap.poll();
        removed.add(arr[1]);
        return arr[0];
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */