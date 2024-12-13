class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int currNum = 0;
        StringBuilder currString = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                currNum*= 10;
                currNum+= c - '0';
            }else if(c == '[') {
                countStack.addFirst(currNum);
                stringStack.addFirst(currString);
                currNum = 0;
                currString = new StringBuilder();
            }else if(c == ']') {
                StringBuilder decoded = stringStack.removeFirst();
                for(int i = countStack.removeFirst(); i > 0; i--) decoded.append(currString);
                currString = decoded;
            }else currString.append(c);
        }
        return currString.toString();
    }
}