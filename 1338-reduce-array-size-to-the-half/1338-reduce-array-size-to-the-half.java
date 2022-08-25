class Solution {
    
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
        for(int key : map.keySet()){
            maxHeap.offer(map.get(key));
        }
        int removed = 0, half = arr.length/2;
        while(half > 0) {
            half-=maxHeap.poll();
            removed++;
        }
        return removed;
    }
}