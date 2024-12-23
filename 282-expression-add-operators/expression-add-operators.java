class Solution {
    private String num = "";
    private int target = 0;
    private List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;

        helper(0, 0, 0, 0, new ArrayList<>());
        return result;    
    }

    private void helper(int ind, long value, long prev, long curr, List<String> expr) {
        //1. Base case/exit condition
        if(ind == num.length()) {
            if(value == target && curr == 0) {
                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < expr.size(); i++) sb.append(expr.get(i));
                result.add(sb.toString());
            }
            return;
        }

        //2. Fix value, shift base 10
        curr*= 10;
        curr+= num.charAt(ind) - '0';

        //3. No op if curr != 0 to avoid leading zeroes 
        if(curr != 0) helper(ind + 1, value, prev, curr, expr);

        //4. Addition
        expr.add("+");
        expr.add(String.valueOf(curr));
        helper(ind + 1, value + curr, curr, 0, expr);
        expr.remove(expr.size() - 1);
        expr.remove(expr.size() - 1);

        //Only if elements already added
        if(expr.size() > 0) {
            //5. Subtraction
            expr.add("-");
            expr.add(String.valueOf(curr));
            helper(ind + 1, value - curr, -curr, 0, expr);
            expr.remove(expr.size() - 1);
            expr.remove(expr.size() - 1);

            //6. Multiplication
            expr.add("*");
            expr.add(String.valueOf(curr));
            helper(ind + 1, value - prev + (prev * curr), prev * curr, 0, expr);
            expr.remove(expr.size() - 1);
            expr.remove(expr.size() - 1);
        }
    }
}