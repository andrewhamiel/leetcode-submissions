class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        vector<int> result;
        int maxHeight = -1;
        
        for(int i = heights.size() - 1; i >= 0; i--){
            if(maxHeight < heights[i]){
                result.push_back(i);
                maxHeight = heights[i];
            }
        }
        reverse(result.begin(), result.end());
        return result;
    }
};