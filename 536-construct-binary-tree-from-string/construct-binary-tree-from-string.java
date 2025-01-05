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
    public TreeNode str2tree(String s) {
        if(s.isEmpty()) return null;

        TreeNode root = new TreeNode();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);

        for(int i = 0; i < s.length(); i++) {
            TreeNode curr = stack.removeFirst();
            //Not started
            if(Character.isDigit(s.charAt(i)) || s.charAt(i) == '-') {
                Pair<Integer, Integer> p = getNumber(i, s);
                i = p.getKey();
                curr.val = p.getValue();

                //First subtree will be left child if any data left
                if(i < s.length() && s.charAt(i) == '(') {
                    stack.addFirst(curr);
                    curr.left = new TreeNode();
                    stack.addFirst(curr.left);
                }
            }else if(s.charAt(i) == '(' && curr.left != null) {
                //Left done
                stack.addFirst(curr);
                curr.right = new TreeNode();
                stack.addFirst(curr.right);
            }
        }
        return !stack.isEmpty() ? stack.removeFirst() : root;
    }

    private Pair<Integer, Integer> getNumber(int ind, String s) {
        boolean isNegative = false;
        if(s.charAt(ind) == '-') {
            isNegative = true;
            ind++;
        }

        int num = 0;
        while(ind < s.length() && Character.isDigit(s.charAt(ind))) {
            num*= 10;
            num+= (s.charAt(ind++) - '0');
        }
        
        if(isNegative) num*= -1;
        return new Pair<>(ind, num);
    }
}