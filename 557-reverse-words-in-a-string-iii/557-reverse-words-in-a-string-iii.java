class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        
        String str = "";
        for(int i = 0; i < arr.length - 1; i++){
            str = str + reverse(arr[i]) + " ";
        }
        str+= reverse(arr[arr.length - 1]);
        return str;
    }
    
    public String reverse(String word){
        int start = 0, end = word.length() - 1;
        char[] arr = word.toCharArray();
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return new String(arr);
    }

}