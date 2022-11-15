import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    
    private Deque<List<NestedInteger>> listStack = new ArrayDeque();
    private Deque<Integer> indexStack = new ArrayDeque();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        listStack.push(nestedList);
        indexStack.push(0);
    }
        
    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        int currentPosition = indexStack.pop();
        indexStack.push(currentPosition + 1);
        Integer ans = listStack.peek().get(currentPosition).getInteger();
        return ans;
    }

    
    @Override
    public boolean hasNext() {
        makeStackTopAnInteger();
        return !indexStack.isEmpty();
    }


    private void makeStackTopAnInteger() {  
        while (!indexStack.isEmpty()) {
            Integer ind = indexStack.peek();
            // If the top list is used up, pop it and its index.
            if (ind >= listStack.peek().size()) {
                indexStack.pop();
                listStack.pop();
                continue;
            }

            // Otherwise, if it's already an integer, we don't need to do anything.
            NestedInteger nestedInteger = listStack.peek().get(ind);
            if (nestedInteger.isInteger()) break;

            // Otherwise, it must be a list. We need to update the previous index
            // and then add the new list with an index of 0.
            listStack.push(nestedInteger.getList());
            indexStack.push(indexStack.pop() + 1);
            indexStack.push(0);
        }
    }
}