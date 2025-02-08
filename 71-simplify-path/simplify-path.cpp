class Solution {
public:
    string simplifyPath(string path) {
        deque<string> stack;

        stringstream ss(path);
        string dir;

        while(getline(ss, dir, '/')) {
            if(dir.empty() || dir == ".") continue;
            else if(dir == "..") {
                if(!stack.empty()) stack.pop_front();
            }else stack.push_front(dir);
        }

        string result;
        while(!stack.empty()) {
            result+= "/" + stack.back();
            stack.pop_back();
        }
        return result.empty() ? "/" : result;
    }
};