class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        dfs(s.toCharArray(), 0);
        return res;
    }

    void dfs(char[] arr, int pos) {
        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        if (arr[pos] >= '0' && arr[pos] <= '9') {
            dfs(arr, pos + 1);
            return;
        }
        arr[pos] = Character.toLowerCase(arr[pos]);
        dfs(arr, pos + 1);
        arr[pos] = Character.toUpperCase(arr[pos]);
        dfs(arr, pos + 1);
    }
}