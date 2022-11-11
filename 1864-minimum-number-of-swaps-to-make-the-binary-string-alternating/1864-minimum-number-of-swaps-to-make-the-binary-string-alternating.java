class Solution {
    //the alternating pattern can be either 010101... or 101010...
    //so we will check the no. of places where our string differs for both these patterns
    public int minSwaps(String s) {       
        //start1 denotes the first char and dif1 keeps count of differences for 010101...
        //start2 denotes the first char and dif2 keeps count of differences for 101010...
        
        //we will also store the count of 0's and 1's as if difference is >1 then no alternating seq possible
        char start1 = '0', start2 = '1';
        int diff1 = 0, diff2 = 0;
        int[] count = new int[2];
        for(char c : s.toCharArray()){
            count[c - '0']++;
            if(c != start1) diff1++;
            if(c != start2) diff2++;
            
            //swap
            char tmp = start1;
            start1 = start2;
            start2 = tmp;
        }
        
        if(Math.abs(count[0] - count[1]) <= 1){
            if(diff1 % 2 == 0 && diff2 % 2 == 0) return Math.min(diff1, diff2)/2;
            else if(diff1 % 2 == 0) return diff1/2;
            else if(diff2 % 2 == 0) return diff2/2;
        }
        return -1;

//         for(char c : s.toCharArray()){
//             //increase the count for the corresponding char
//             count[c-'0']++;     
//             //if current char is not same as what we expect for our pattern we increase the diff for that pattern
//             if(c!=start1) dif1++;
//             if(c!=start2) dif2++;
            
//             //swapping the next expected char for both patterns
//             char temp=start1;
//             start1=start2;
//             start2=temp;
//         }
//         //if absolute diff > 1 then no ans possible
//         if(Math.abs(count[0]-count[1])<=1){
//             // to get an ans the no. of diff for the pattern should be even as then only swapping would solve it
//             if(dif2 % 2 == 0 && dif1 % 2 == 0) return Math.min(dif1,dif2)/2;
//             if(dif2%2==0) return dif2/2;
//             if(dif1%2==0) return dif1/2;
//         }
//         return -1;
    }
    
}