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
    private int i = 0;
    Stack<String> prefix = new Stack();
    Stack<Character> ops = new Stack();
    
    public Node expTree(String s) {
        return createTree(convertToPrefix(s));
    }
    
    private Node createTree(String str){
        char c = str.charAt(i++);
        Node node = new Node(c);
        if(c == '+' || c == '-' || c == '*' || c == '/'){
            if(node.left == null) node.left = createTree(str);
            if(node.right == null) node.right = createTree(str);
        }
        return node;
    }
    
    /*
        * Build binary expression string
        * 4 cases:
        * 1. c == '('
        * 2. c == ')'
        * 3. c == operator
        * 4. c == number
        */
    private String convertToPrefix(String s){
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //case 1: c == '('
            if(c == '(') ops.push(c);
            //case 2: c == ')'
            else if(c == ')'){
                while(ops.peek() != '('){
                    prefix.push(buildPrefixString());
                }
                ops.pop(); //remove '('
            }
            //case 3: c is operator
            else if(c == '+' || c == '-' || c == '*' || c == '/'){
                while(!ops.isEmpty() && ops.peek() != '(' && precedence(c) <= precedence(ops.peek())){
                    prefix.push(buildPrefixString());
                }
                ops.push(c);
            }
            //case 4: c is a number
            else prefix.push(String.valueOf(c));
        }
        //combine remaining binary expressions
        while(!ops.isEmpty()){
            prefix.push(buildPrefixString());
        }
        return prefix.pop();
    }
    
    private int precedence(char c){
        return c == '+' || c == '-' ? 1 : 2;
    }
    
    private String buildPrefixString(){
        String val2 = prefix.pop(), val1 = prefix.pop();
        char op = ops.pop();
        return new StringBuilder().append(op).append(val1).append(val2).toString();
    }
}