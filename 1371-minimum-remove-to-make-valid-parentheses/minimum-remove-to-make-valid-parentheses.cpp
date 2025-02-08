class Solution {
public:
    string minRemoveToMakeValid(string s) {
        string result;
        unordered_set<int> toBeRemoved;
        deque<int> leftParens;
        for(int i = 0; i < s.size(); i++) {
            char c = s[i];
            if(c == '(') leftParens.push_front(i);
            else if(c == ')') {
                if(!leftParens.empty()) leftParens.pop_front();
                else toBeRemoved.insert(i);
            }
        }

        while(!leftParens.empty()) {
            toBeRemoved.insert(leftParens.front());
            leftParens.pop_front();
        }

        for(int i = 0; i < s.size(); i++) {
            if(!toBeRemoved.contains(i)) result+= s[i];
        }
        return result;
    }
};