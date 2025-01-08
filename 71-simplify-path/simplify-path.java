class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for(String dir : path.split("/")) {
            if(dir.isEmpty() || dir.equals(".")) continue;
            else if(dir.equals("..")) {
                if(!stack.isEmpty()) stack.removeFirst();
            }else stack.addFirst(dir);
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }
        return result.isEmpty() ? "/" : result.toString();
    }
}