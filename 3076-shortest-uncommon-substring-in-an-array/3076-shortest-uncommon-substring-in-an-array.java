class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String res = "";
            for (int size = 1; size <= arr[i].length() && res.isEmpty(); size++) {
                for (int j = size; j <= arr[i].length(); j++) {
                    String t = arr[i].substring(j - size, j);
                    if ((res.isEmpty() || t.compareTo(res) < 0) && check(arr, i, t))
                        res = t;
                }
            }
            ans[i] = res;
        }
        return ans;
    }

    boolean check(String[] arr, int index, String t) {
        for (int i = 0; i < arr.length; i++) {
            if (i != index && arr[i].contains(t))
                return false;
        }
        return true;
    }
}