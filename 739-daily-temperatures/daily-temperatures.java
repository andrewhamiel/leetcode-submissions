class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }
        
        return answer;
    }
}