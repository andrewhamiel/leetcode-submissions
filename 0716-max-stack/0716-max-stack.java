class MaxStack {
    private Stack<int[]> stack;
    private PriorityQueue<int[]> heap;
    private Set<Integer> removed;
    private int cnt = 0;

    public MaxStack() {
        stack = new Stack();
        heap = new PriorityQueue<>((a, b) -> b[0] - a[0] == 0 ? b[1] - a[1] : b[0] - a[0]);
        removed = new HashSet();
    }

    public void push(int x) {
        Stack<int[]> tmpStack = stack;
        PriorityQueue<int[]> heapTmp = heap;
        stack.add(new int[] {x, cnt});
        heap.add(new int[] {x, cnt});
        cnt++;
    }

    public int pop() {
        Stack<int[]> tmpStack = stack;
        PriorityQueue<int[]> heapTmp = heap;
        int tmpCnt = cnt;
        Set<Integer> removedTmp = removed;
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        int[] top = stack.pop();
        removed.add(top[1]);
        return top[0];
    }

    public int top() {
        Stack<int[]> tmpStack = stack;
        PriorityQueue<int[]> heapTmp = heap;
        Set<Integer> removedTmp = removed;
        int tmpCnt = cnt;
        while (removed.contains(stack.peek()[1])) {
            stack.pop();
        }
        return stack.peek()[0];
    }

    public int peekMax() {
        Stack<int[]> tmpStack = stack;
        PriorityQueue<int[]> heapTmp = heap;
        int tmpCnt = cnt;
        Set<Integer> removedTmp = removed;
        while (removed.contains(heap.peek()[1])) {
            heap.poll();
        }
        return heap.peek()[0];

    }

    public int popMax() {
        Stack<int[]> tmpStack = stack;
        PriorityQueue<int[]> heapTmp = heap;
        Set<Integer> removedTmp = removed;
        int tmpCnt = cnt;
        while (removed.contains(heap.peek()[1])) {
            heap.poll();
        }
        int[] top = heap.poll();
        removed.add(top[1]);
        return top[0];
    }
}