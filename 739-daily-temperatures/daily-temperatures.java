class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int currDay = 0; currDay < temperatures.length; currDay++){
            int currentTemp = temperatures[currDay];
            while(!stack.isEmpty() && temperatures[stack.peekFirst()] < currentTemp){
                int prevDay = stack.removeFirst();
                result[prevDay] = currDay - prevDay;
            }
            stack.addFirst(currDay);
        }
        return result;
    }
}