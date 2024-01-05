class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            map[arr[i] - 'a'] = i;
        }
        int l = 0, r = 0, last = -1;
        while (l < arr.length) {
            int pos = map[arr[l] - 'a'];
            if (pos > r) {
                r = pos;
            }
            if (l == r) {
                ans.add(l - last);
                last = l;
                if (l + 1 < arr.length)
                    r = map[arr[l + 1] - 'a'];
            }
            l++;
        }
        return ans;
    }
}