class RandomizedSet {
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> list = new ArrayList<>();
    private Random rand = new Random();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int ind = map.get(val);
        int lastElement = list.get(list.size() - 1);
        map.put(lastElement, ind);
        map.remove(val);
        list.set(ind, lastElement);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */