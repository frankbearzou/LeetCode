class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] arr = new int[n + 1];
        int cur = rounds[0];
        int index = 1;
        while (index < rounds.length) {
            while (cur != rounds[index]) {
                arr[cur]++;
                cur = (cur + 1) % (n + 1);
            }
            arr[cur]++;
            cur = (cur + 1) % (n + 1);
            index++;
        }
        int max = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ans.clear();
                ans.add(i);
            } else if (arr[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }
}