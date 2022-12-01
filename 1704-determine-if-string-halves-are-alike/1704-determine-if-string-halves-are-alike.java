class Solution {
    public boolean halvesAreAlike(String s) {
        return countVowel(0, s.length()/2, s) == countVowel(s.length()/2, s.length(), s);
    }

    private int countVowel(int start, int end, String s) {
        String vowels = "aeiouAEIOU";
        int answer = 0;
        for (int i = start; i < end; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) answer++;
        }
        return answer;
    }
}