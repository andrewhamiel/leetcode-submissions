/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int ind = 0;
    private Stack<String> prefix = new Stack();
    private Stack<Character> ops = new Stack();
    
    public Node expTree(String s) {
        return buildTree(createPrefixExpString(s));
    }
    
    private Node buildTree(String str){
        char c = str.charAt(ind++);
        Node node = new Node(c);
        if(c == '+' || c == '-' || c == '*' || c == '/'){
            if(node.left == null) node.left = buildTree(str);
            if(node.right == null) node.right = buildTree(str);
        }
        return node;
    }
    
    private String createPrefixExpString(String s){
        //4 cases
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //case 1: c == '('
            if(c == '(') ops.push(c);
            //case 2: c == ')'
            else if(c == ')'){
                while(ops.peek() != '('){
                    prefix.push(buildPrefix());
                }
                ops.pop(); //clean up '('
            }
            //case 3: c is an operator
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                while(!ops.isEmpty() && ops.peek() != '(' && precedence(c) <= precedence(ops.peek())){
                    prefix.push(buildPrefix());
                }
                ops.push(c);
            }
            //case 4: c is a number
            else prefix.push(String.valueOf(c));
        }
        
        //build any remaining ops
        while(!ops.isEmpty()){
            prefix.push(buildPrefix());
        }
        return prefix.pop();
    }
    
    private int precedence(char c){
        return c == '+' || c == '-' ? 1 : 2;
    }
    
    private String buildPrefix(){
        String val2 = prefix.pop(), val1 = prefix.pop();
        char op = ops.pop();
        return new StringBuilder().append(op).append(val1).append(val2).toString();
    }
}