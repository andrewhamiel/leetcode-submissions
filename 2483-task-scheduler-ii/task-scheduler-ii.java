class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> last = new HashMap<>();
        long days = 0;
        for (int taskType : tasks)
            if (last.containsKey(taskType)){
                days = Math.max(days, last.get(taskType) + space) + 1;
                last.put(taskType, days);
            } 
            else {
                days++;
                last.put(taskType, days);
            }
        return days;
    }
}