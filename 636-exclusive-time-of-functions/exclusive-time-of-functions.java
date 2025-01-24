class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;
        for(String log : logs) {
            String[] colonDelimited = log.split(":");
            int currTime = Integer.parseInt(colonDelimited[2]), functionId = Integer.parseInt(colonDelimited[0]);
            if("start".equals(colonDelimited[1])) {
                if(!stack.isEmpty()) result[stack.peekFirst()]+= currTime - prevTime;
                stack.addFirst(functionId);
            }else {
                currTime++; //Ending function takes one unit of time
                result[stack.removeFirst()]+= currTime - prevTime;
            }
            prevTime = currTime;
        }
        return result;
    }
}