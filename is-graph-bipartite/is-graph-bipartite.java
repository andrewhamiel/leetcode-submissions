class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i = 0; i < graph.length; i++){
            if(colors[i] == -1){
                colors[i] = 0;
                Stack<Integer> stack = new Stack();
                stack.push(i);
                while(!stack.isEmpty()){
                    Integer node = stack.pop();
                    for(int edge : graph[node]){
                        if(colors[edge] == -1){
                            stack.push(edge);
                            colors[edge] = colors[node]^1;
                        }else if(colors[edge] == colors[node]) return false;
                    }
                }
            }
        }
            
        return true;
    }
}