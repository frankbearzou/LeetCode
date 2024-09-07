class Solution {
    vector<vector<int>> ans;
    vector<int> path;
    vector<int> nums;
    int n;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        this->nums = nums;
        this->n = nums.size();
        dfs(0);
        return ans;
    }

    void dfs(int i) {
        if (i == n) {
            ans.emplace_back(path);
            return;
        }
        dfs(i + 1);
        path.push_back(nums[i]);
        dfs(i + 1);
        path.pop_back();
    }
};