class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean hasZero = false;
        for (int i : arr) {
            if (i == 0) {
                hasZero = true;
                break;
            }
        }
        if (!hasZero)
            return false;
        return dfs(arr, start);
    }

    boolean dfs(int[] arr, int start) {
        if (arr[start] == 0)
            return true;
        if (arr[start] < 0)
            return false;
        int l = start - arr[start], r = start + arr[start], n = arr.length;
        arr[start] *= -1;
        if (l >= 0 && r < n)
            return dfs(arr, l) || dfs(arr, r);
        if (l >= 0)
            return dfs(arr, l);
        if (r < n)
            return dfs(arr, r);
        return false;
    }
}