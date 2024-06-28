class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        stack<int> stack;
        vector<int> result;
        stack.push(heights.size() - 1);
        for(int i = heights.size() - 2; i >= 0; i--){
            if(heights[i] > heights[stack.top()]){
                stack.push(i);
            }
        }
        while(!stack.empty()){
            result.push_back(stack.top());
            stack.pop();
        }
        return result;
    }
};