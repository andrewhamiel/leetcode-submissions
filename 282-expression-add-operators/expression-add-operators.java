class Solution {
    private List<String> result = new ArrayList<>();
    private String num = "";
    private int target = 0;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        backtrack(0, 0, 0, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int ind, long value, long prev, long curr, List<String> expr) {
        //1. Exit condition
        if(ind == num.length()) {
            if(value == target && curr == 0) {
                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < expr.size(); i++) sb.append(expr.get(i));
                result.add(sb.toString());
            }
            return;
        }

        //2. Fix curr, shift base 10
        curr*= 10;
        curr+= num.charAt(ind) - '0';
        //3. If curr != 0, no op to avoid leading zero
        if(curr != 0) backtrack(ind + 1, value, prev, curr, expr);
        //4. Addition
        expr.addAll(Arrays.asList("+", String.valueOf(curr)));
        backtrack(ind + 1, value + curr, curr, 0, expr);
        expr.subList(expr.size() - 2, expr.size()).clear();
        //5. If not empty expression
        if(!expr.isEmpty()) {
            //6. Subtraction
            expr.addAll(Arrays.asList("-", String.valueOf(curr)));
            backtrack(ind + 1, value - curr, -curr, 0, expr);
            expr.subList(expr.size() - 2, expr.size()).clear();
            //7. Multiplication
            expr.addAll(Arrays.asList("*", String.valueOf(curr)));
            backtrack(ind + 1, value - prev + (prev * curr), prev * curr, 0, expr);
            expr.subList(expr.size() - 2, expr.size()).clear();
        }
    }
}