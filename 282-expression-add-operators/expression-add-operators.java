class Solution {
    List<String> ans = new ArrayList<>();
    String num;
    int target = 0;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        helper(0, 0, 0, 0, new ArrayList<>());
        return ans;
    }

    private void helper(int index, long value, long prevOperand, long currOperand, List<String> expression){
        //if index == nums.length and no curr ops to evaluate
        if(index == num.length() ){
            if(currOperand == 0 && value == target){
                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < expression.size(); i++) sb.append(expression.get(i));
                ans.add(sb.toString());
            }
            return;
        }

        //convert to correct digit
        long correctDigit = (currOperand * 10) + Character.getNumericValue(num.charAt(index));

        //No Op. Need to make sure current operand not zero to avoid leading zero
        if(correctDigit > 0){
            helper(index + 1, value, prevOperand, correctDigit, expression);
        }
        

        //Addition
        expression.add("+");
        expression.add(Long.toString(correctDigit));
        helper(index + 1, value + correctDigit, correctDigit, 0, expression);
        expression.remove(expression.size() - 1);
        expression.remove(expression.size() - 1);
        
        if(expression.size() > 0){
            //Subtraction
            expression.add("-");
            expression.add(Long.toString(correctDigit));
            helper(index + 1, value - correctDigit, -correctDigit, 0, expression);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);
            //Multiplication
            expression.add("*");
            expression.add(Long.toString(correctDigit));
            helper(index + 1, value - prevOperand + (correctDigit * prevOperand) ,correctDigit * prevOperand, 0, expression);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);
        }

    }
}