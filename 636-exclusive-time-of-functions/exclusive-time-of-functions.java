class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        int prevTime = 0;
        for(String log : logs) {
            String[] commaDelimited = log.split(":");
            int currTime = Integer.parseInt(commaDelimited[2]);
            if("start".equals(commaDelimited[1])) {
                if(!stack.isEmpty()) result[stack.peekFirst()]+= currTime - prevTime;
                stack.addFirst(Integer.parseInt(commaDelimited[0]));
                prevTime = currTime;
            }else {
                currTime++; //ending function takes one unit of time;
                result[stack.removeFirst()]+= currTime - prevTime;
                prevTime = currTime;
            }
        }
        return result;
    }
}