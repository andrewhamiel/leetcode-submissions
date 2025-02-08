class Solution {
public:
    string simplifyPath(string path) {
        deque<string> stack;

        stringstream ss(path);
        string dir;
        while(getline(ss, dir, '/')) {
            if(dir.empty() || dir == ".") continue;
            else if(dir == "..") {
                if(!stack.empty()) stack.pop_back();
            }else stack.push_back(dir);
        }

        string result;
        while(!stack.empty()) {
            result+= "/" + stack.front();
            stack.pop_front();
        }
        return result.empty() ? "/" : result;
    }
};