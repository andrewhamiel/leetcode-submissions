class Solution {
    public int[] numMovesStones(int a, int b, int c) {
       int arr[]=new int[]{a, b, c};
       Arrays.sort(arr);

       int max=(arr[1]-arr[0]-1)+(arr[2]-arr[1]-1), min=0;
       if(arr[2]-arr[1]==1){
          min=Math.min(arr[1]-arr[0]-1,1);
       } else{
           if(arr[1]-arr[0]==1){
               min=1;
           }else{
               if(arr[2]-arr[1]==2 || arr[1]-arr[0]==2)  min=1;
               else min=2;   
           }
       }

       int result[]=new int[]{min, max};
       return result;
    }
}