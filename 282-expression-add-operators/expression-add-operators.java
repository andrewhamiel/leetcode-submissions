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
                StringBuilder adding = new StringBuilder();
                for(int i = 1; i < expr.size(); i++) adding.append(expr.get(i));
                result.add(adding.toString());
            }
            return;
        }

        //1. Shift number left base 10
        curr*= 10;
        curr+= (int)(num.charAt(ind) - '0');

        //2. No op if != 0 to avoid leading zeroes
        if(curr != 0) helper(ind + 1, value, prev, curr, expr);

        //3. Add
        expr.add("+");
        expr.add(Long.toString(curr));
        helper(ind + 1, value + curr, curr, 0, expr);
        cleanupBacktrack(expr);


        if(expr.size() > 0){
            //4. Subtract
            expr.add("-");
            expr.add(Long.toString(curr));
            helper(ind + 1, value - curr, -curr, 0, expr);
            cleanupBacktrack(expr);

            //5. multiply
            expr.add("*");
            expr.add(Long.toString(curr));
            helper(ind + 1, value - prev + (prev * curr), prev * curr, 0, expr);
            cleanupBacktrack(expr);
        }
    }
    private void cleanupBacktrack(List<String> expr){
        expr.remove(expr.size() - 1);
        expr.remove(expr.size() - 1);
    }
}