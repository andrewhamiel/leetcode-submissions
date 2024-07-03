class Solution {
public:
    bool validWordAbbreviation(string word, string abbr) {
        int wordInd = 0, abbrInd = 0, currNum = 0;
        while(abbrInd < abbr.size()){
            if(isdigit(abbr.at(abbrInd))){
                if(currNum == 0 && abbr.at(abbrInd) == '0') return false;
                currNum*= 10;
                currNum+= (int)(abbr.at(abbrInd++) - '0');
            }else{
                wordInd+= currNum;
                currNum = 0;
                if(wordInd >= word.size() || word.at(wordInd++) != abbr.at(abbrInd++)) return false;
            }
        }
        if(currNum > 0) wordInd+= currNum;
        return wordInd == word.size();
    }
};