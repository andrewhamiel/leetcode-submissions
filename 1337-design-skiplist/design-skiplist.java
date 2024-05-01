class Skiplist {

    Map<Integer,Integer> map;
    public Skiplist() {
        map = new HashMap<>();
    }
    
    public boolean search(int target) {
    if(map.containsKey(target)) return true;
    return false;
    }
    
    public void add(int num) {
    map.put(num, map.getOrDefault(num,0)+1);  
    }
    
    public boolean erase(int num) {
        if(!map.containsKey(num)){ 
            return false;
        }else{
            if(map.get(num)==1) map.remove(num);
            else map.put(num, map.getOrDefault(num,0)-1);
        }
        return true;
    }
}