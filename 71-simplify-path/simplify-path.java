class Solution {
    public String simplifyPath(String path) {
        Deque<String> deq = new ArrayDeque<>();
        for(String dir : path.split("/")) {
            if(dir.isEmpty() || dir.equals(".")) continue;
            else if(dir.equals("..")) {
                if(!deq.isEmpty()) deq.removeFirst();
            }else deq.addFirst(dir);
        }

        StringBuilder result = new StringBuilder();
        while(!deq.isEmpty()) {
            result.append('/').append(deq.removeLast());
        }
        return result.isEmpty() ? "/" : result.toString();
    }
}