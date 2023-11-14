class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int asteroid : asteroids){
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                if(asteroid+stack.peek() < 0) stack.pop();
                else if(asteroid+stack.peek() == 0){
                    stack.pop();
                    asteroid = 0;
                }
                else if(asteroid + stack.peek() > 0) {
                    asteroid = 0;
                    break;
                }
            }
            if(asteroid != 0) stack.push(asteroid);
        }
        int[] results = new int[stack.size()];
        for(int i = results.length-1; i>=0; i--) results[i] = stack.pop();
        return results;
    }
}