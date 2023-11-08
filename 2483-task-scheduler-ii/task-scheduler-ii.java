class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> map = new HashMap<>();
        long days = 0;
        for(int taskType : tasks){
            if(map.containsKey(taskType)){
                days = Math.max(days, map.get(taskType) + space);
                days++;
                map.put(taskType, days);
            }else{
                days++;
                map.put(taskType, days);
            }
        }
        return days;
    }
}