class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        int currCount = 0;
        StringBuilder currString = new StringBuilder();
        for(char c : s.toCharArray()) {
            //1. Digit
            //2. Open bracket
            //3. Closed bracket
            //4. letter
            if(Character.isDigit(c)) {
                currCount*= 10;
                currCount+= c - '0';
            }else if(c == '[') {
                countStack.addFirst(currCount);
                stringStack.addFirst(currString);
                currCount = 0;
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