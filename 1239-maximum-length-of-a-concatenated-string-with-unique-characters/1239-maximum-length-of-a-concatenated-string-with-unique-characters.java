class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, "", 0);
        return max;
    }

    void dfs(List<String> arr, String path, int index) {
        if (index > arr.size())
            return;
        if (duplicate(path))
            return;
        max = Math.max(max, path.length());
        for (int i = index; i < arr.size(); i++) {
            dfs(arr, path + arr.get(i), i + 1);
        }
    }

    boolean duplicate(String str) {
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c))
                return true;
            set.add(c);
        }
        return false;
    }
}