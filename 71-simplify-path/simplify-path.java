class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String dir : dirs){          
            if(!stack.isEmpty() && dir.equals("..")) stack.removeFirst();
            else if(dir.equals(".") || dir.equals("/") || dir.equals("..") || dir.isEmpty()) continue;
            else stack.addFirst(dir);
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append("/");
            result.append(stack.removeLast());
            
        }
        return result.isEmpty() ? "/" : result.toString();
    }
}