class Solution {
    public boolean halvesAreAlike(String s) {
        String str1 = s.substring(0, s.length()/2), str2 = s.substring(s.length()/2);

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        int str1Vowels = 0, str2Vowels = 0;
        for(char c : str1.toCharArray()){
            if(vowels.contains(c)){
                str1Vowels++;
            }
        }

        for(char c : str2.toCharArray()){
            if(vowels.contains(c)) str2Vowels++;
        }

        return str1Vowels == str2Vowels;
    }
}