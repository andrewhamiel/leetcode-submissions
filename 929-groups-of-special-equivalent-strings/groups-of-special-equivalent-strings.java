class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> result = new HashSet<>();

        for(String str:words){
            int[] odd = new int[26];
            int[] even = new int[26];
            for(int i=0;i<str.length();i++){
                if(i%2==0){
                    even[str.charAt(i)-'a']++;
                }else{
                    odd[(str.charAt(i)-'a')]++;
                }
            }
            result.add(Arrays.toString(odd)+Arrays.toString(even));
        }

        return result.size();
    }
}