class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    
    public RandomizedSet(){
        map = new HashMap();
        list = new ArrayList();
        rand = new Random();
    }
    
    public boolean insert(int val){
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }
    
    public boolean remove(int val){
        if(!map.containsKey(val)) return false;
        int ind = map.get(val);
        Integer last = list.get(list.size() - 1);
        list.set(ind, last);
        map.put(last, ind);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom(){
        return list.get(rand.nextInt(list.size()));
    }
}