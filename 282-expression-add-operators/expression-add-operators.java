class Solution {
    List<String> result = new ArrayList<>();
    String num = "";
    int target = 0;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        helper(0, 0, 0, 0, new ArrayList<>());
        return result;
    }

    private void helper(int ind, long value, long prevOperand, long currOperand, List<String> expression){
        //0. Exit condition
        if(ind == num.length()){
            if(currOperand == 0 && value == target){
                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < expression.size(); i++) sb.append(expression.get(i));
                result.add(sb.toString());
            }
            return;
        }

        //1. Correct currOperand to shift base 10
        currOperand*= 10;
        currOperand+= (int)(num.charAt(ind) - '0');

        //2. No op if not equal to 0 to avoid leading zeroes
        if(currOperand > 0) helper(ind + 1, value, prevOperand, currOperand, expression);

        //3. Addition
        expression.add("+");
        expression.add(Long.toString(currOperand));
        helper(ind + 1, value + currOperand, currOperand, 0, expression);
        cleanupBacktrack(expression);

        if(expression.size() > 0){
            //4. Subtraction
            expression.add("-");
            expression.add(Long.toString(currOperand));
            helper(ind + 1, value - currOperand, -currOperand, 0, expression);
            cleanupBacktrack(expression);
            //5. Multiplication
            expression.add("*");
            expression.add(Long.toString(currOperand));
            helper(ind + 1, value - prevOperand + (prevOperand * currOperand), prevOperand * currOperand, 0, expression);
            cleanupBacktrack(expression);
        }
    }

    private void cleanupBacktrack(List<String> expression){
        expression.remove(expression.size() - 1);
        expression.remove(expression.size() - 1);
    }
}