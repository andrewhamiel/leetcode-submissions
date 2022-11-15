import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    
    Deque<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList){
        stack=  new ArrayDeque(nestedList);
    }
    
    @Override
    public Integer next(){
        if(!hasNext()) throw new NoSuchElementException();
        return stack.pop().getInteger();
    }
    
    @Override
    public boolean hasNext() {
        makeStackTopAnInteger();
        return !stack.isEmpty();
    }
    
    private void makeStackTopAnInteger(){
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            List<NestedInteger> list = stack.pop().getList();
            for(int i = list.size() - 1; i >= 0; i--) stack.push(list.get(i));
        }
    }
}