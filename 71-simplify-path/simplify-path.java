class Solution {
    public String simplifyPath(String path) {
        String[] split =  path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String level : split){
            if(level.equals("/") || level.equals(".") || level.isEmpty()) continue;
            else if(level.equals("..")){
                if(!stack.isEmpty()) stack.removeFirst();
            }else{
                stack.addFirst(level);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.removeLast());
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }
}