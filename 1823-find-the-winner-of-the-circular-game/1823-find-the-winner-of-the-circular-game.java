class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            int del = (index + k - 1) % list.size();
            list.remove(del);
            index = del;
        }
        return list.get(0);
    }
}