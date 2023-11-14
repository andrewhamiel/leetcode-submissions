class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int asteroid : asteroids){
            while(!stack.isEmpty() && stack.peekFirst() > 0 && asteroid < 0){
                int sum = stack.peekFirst() + asteroid;
                if(sum < 0) stack.removeFirst();
                else if(sum == 0){
                    asteroid = 0;
                    stack.removeFirst();
                }else if(sum > 0){
                    asteroid = 0;
                    break;
                }
            }
            if(asteroid != 0) stack.addFirst(asteroid);
        }

        int[] result = new int[stack.size()];
        for(int i = 0; i < result.length; i++) result[i] = stack.removeLast();
        return result;
    }
}