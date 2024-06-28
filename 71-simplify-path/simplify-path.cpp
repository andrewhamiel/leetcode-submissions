class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stack;

        //used to split by '/'
        stringstream ss(path);
        string tmp;
        while(getline(ss, tmp, '/')) {
            if(tmp == ".."){
                if(!stack.empty()) stack.pop_back();
            }else if(tmp != "." && !tmp.empty()){
                stack.push_back(tmp);
            }
        }

        string result = "";
        for(auto str : stack) result+= "/" + str;

        return result.empty() ? "/" : result;
    }
};