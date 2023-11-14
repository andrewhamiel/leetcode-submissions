class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int currDay = 0; currDay < temperatures.length; currDay++){
            int currTemp = temperatures[currDay];

            while(!stack.isEmpty() && temperatures[stack.peekFirst()] < currTemp){
                int prevDay = stack.removeFirst();
                result[prevDay] = currDay - prevDay;
            }
            stack.addFirst(currDay);
        }
        return result;
    }
}