class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(n == 0 || logs == null || logs.size() == 0) return result;
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;

        for(String log : logs){
            String[] colonDelimited = log.split(":");
            int currTime = Integer.parseInt(colonDelimited[2]);
            if("start".equals(colonDelimited[1])){
                if(!stack.isEmpty()) result[stack.peekFirst()]+= currTime - prevTime;
                stack.addFirst(Integer.parseInt(colonDelimited[0]));
                prevTime = currTime;
            }else{
                currTime++;
                result[stack.removeFirst()]+= currTime - prevTime;
                prevTime = currTime;
            }
        }
        return result;
    }
}