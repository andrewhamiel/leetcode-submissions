class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for(String dir : dirs){
            if(dir.equals(".") || dir.isEmpty() || dir.equals("/")) continue;
            else if(dir.equals("..")){
                if(!stack.isEmpty()) stack.removeFirst();
            }else stack.addFirst(dir);
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append("/");
            result.append(stack.removeLast());
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}