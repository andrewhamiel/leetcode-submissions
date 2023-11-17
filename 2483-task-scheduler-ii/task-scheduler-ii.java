class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long days = 0;
        for(int task : tasks){
            if(map.containsKey(task)) days = Math.max(days, map.get(task) + space);
            days++;
            map.put(task, days);
        }
        return days;
    }
}