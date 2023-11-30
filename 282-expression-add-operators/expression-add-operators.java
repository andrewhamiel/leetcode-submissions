class Solution {
    List<String> result = new ArrayList<>();
    String num;
    int target = 0;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        helper(0, 0, 0, 0, new ArrayList<>());
        return result; 
    }

    private void helper(int ind, long value, long prev, long curr, List<String> expr){
        //0. Exit condition
        if(ind == num.length()){
            if(value == target && curr == 0){
                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < expr.size(); i++) sb.append(expr.get(i));
                result.add(sb.toString());
            }
            return;
        }

        //1. Fix curr, add next digit shifting left base 10
        curr*= 10;
        curr+= (int)(num.charAt(ind) - '0');

        //2. No op if != 0 to avoid leading zeroes
        if(curr != 0) helper(ind + 1, value, prev, curr, expr);

        //3. Add
        expr.add("+");
        expr.add(Long.toString(curr));
        helper(ind + 1, value + curr, curr, 0, expr);
        expr.remove(expr.size() - 1);
        expr.remove(expr.size() - 1);

        //if there is another value present, subtract/multiply
        if(expr.size() > 0){
            //4. subtract
            expr.add("-");
            expr.add(Long.toString(curr));
            helper(ind + 1, value - curr, -curr, 0, expr);
            expr.remove(expr.size() - 1);
            expr.remove(expr.size() - 1);
            //5. Multiply
            expr.add("*");
            expr.add(Long.toString(curr));
            helper(ind + 1, value - prev + (prev * curr), prev * curr, 0, expr);
            expr.remove(expr.size() - 1);
            expr.remove(expr.size() - 1);
        }
    }
}