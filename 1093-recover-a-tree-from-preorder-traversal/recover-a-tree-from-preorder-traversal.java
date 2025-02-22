/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int level = 0, i = 0;

        while(i < traversal.length()){
            int num = 0;
            //1. parse digits 
            while(i < traversal.length() && Character.isDigit(traversal.charAt(i))){
                num*= 10;
                num+= (int)(traversal.charAt(i++) - '0');
            }
            //2. reset stack to level 
            while(!stack.isEmpty() && stack.size() > level) stack.removeFirst();

            //3. Create new node 
            TreeNode node = new TreeNode(num);

            //4. attach to parent 
            if(!stack.isEmpty()){
                if(stack.peek().left == null) stack.peek().left = node;
                else stack.peek().right = node;
            }
            //5. parse level 
            level = 0;
            while(i < traversal.length() && traversal.charAt(i) == '-'){
                i++;
                level++;
            }
            //6. add to stack 
            stack.addFirst(node);
        }
        //7. clean stack 
        while(stack.size() > 1) stack.removeFirst();
        return stack.removeFirst();
    }
}