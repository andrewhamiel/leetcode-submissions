/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
int max_diameter = 0;

public:
    int diameterOfBinaryTree(TreeNode* root) {
        dfs(root);
        return max_diameter;
    }


private:
    int dfs(TreeNode* root) {
        if(root == nullptr) return 0;

        int left = dfs(root->left), right = dfs(root->right);
        max_diameter = max(max_diameter, left + right);
        return 1 + max(left, right);
    }
};