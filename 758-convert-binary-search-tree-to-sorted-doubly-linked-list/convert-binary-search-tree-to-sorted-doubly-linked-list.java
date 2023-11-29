class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        Node first = null, last = null;

        while(root != null){
            if(root.left != null){
                Node predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) predecessor = predecessor.right;

                if(predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }else{
                    //already explored
                    if(last != null) last.right = root;
                    root.left = last;
                    last = root;
                    root = root.right;
                }
            }else{
                if(first == null) first = root;
                if(last != null) last.right = root;
                root.left = last;
                last = root;
                root = root.right;
            }
        }

        last.right = first;
        first.left = last;
        return first;
    }
}