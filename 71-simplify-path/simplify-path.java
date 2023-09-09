class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");
        for(String directory : components){
            if(directory.equals(".") || directory.isEmpty()) continue;
            else if(directory.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else stack.push(directory);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.removeLast());
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}