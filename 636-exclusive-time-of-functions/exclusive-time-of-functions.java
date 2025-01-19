class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        int prevTime = 0;
        for(String log : logs) {
            String[] split = log.split(":");
            int currTime = Integer.parseInt(split[2]), functionId = Integer.parseInt(split[0]);
            if("start".equals(split[1])) {
                if(!stack.isEmpty()) result[stack.peekFirst()]+= currTime - prevTime;
                stack.addFirst(functionId);
            }else {
                currTime++; //Ending function takes 1 unit of time
                result[stack.removeFirst()]+= currTime - prevTime;
            }
            prevTime = currTime;
        }
        return result;
    }
}