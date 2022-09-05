class Solution {
    public int triangularSum(int[] nums) {
        Queue<int[]> q = new LinkedList();
        q.add(nums);
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr.length == 1) return curr[0];
            int[] next = new int[curr.length - 1];
            for(int i = 0; i < curr.length - 1; i++){
                next[i] = (curr[i] + curr[i+1]) % 10;
            }
            q.add(next);
        }
        return -1;
    }
}