class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;
        for(String log : logs) {
            String[] commaDelimited = log.split(":");
            int currTime = Integer.parseInt(commaDelimited[2]), functionId = Integer.parseInt(commaDelimited[0]);
            if("start".equals(commaDelimited[1])) {
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