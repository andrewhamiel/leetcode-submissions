class Solution {
    //Math. Time: O(1)
    //Space: O(1)
    /*
    *There is no number 3 for the n = 2, n = 3 and n = 4. These are our edge cases. Otherwise, there is a clear pattern that emerges. In plain English, our algorithm would be

For the input number n, if only threes can be used without remainder, return the product of the amount of threes that make it up.
Otherwise, if there is a remainder of 1 when subtracting threes, use one less three than you can fit, and multiply by 2 and then 2 again (because 3*1 < 2*2). Return this product.
Lastly if there is a remainder of 2 when subtracting threes, use as many threes as possible, and then finally a 2. Return this product.
This behavior with finding how many of a number fit, and the remainder is what characterizes the modulo operation. This brings us to...
    */
    private static final int[] bases = {0,0,1,2,4};
    public int integerBreak(int n) {
        if(n <= 4)
          return bases[n];
        else
          switch(n%3){
            case 0 :
              return (int) Math.pow(3,n/3);
            case 1 :
              return (int) Math.pow(3,n/3 - 1)*2*2;
            default: // case 2
              return (int) Math.pow(3,n/3)*2;
          }
    }
}