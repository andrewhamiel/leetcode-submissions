class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        int masH = 1, minH = 0;
        TreeNode temp = null;
        while(root!=null) {
            if(root.right == null) {
                //check
                if(list.size()<masH) list.add(root.val);
                masH++;
                root = root.left;
            }
            else {
                temp = root.right;
                minH = 1;
                while(temp.left!=null && temp.left!=root) {
                    temp = temp.left;
                    minH++;
                }
                if(temp.left == null) {
                    //check
                    if(list.size()<masH) list.add(root.val);
                    temp.left = root;
                    masH++;
                    root = root.right;
                }
                else {
                    temp.left = null;
                    //subtract from height as we are climbing back up
                    masH-=minH;
                    root = root.left;
                }
            }
        }
        return list;
    }
}