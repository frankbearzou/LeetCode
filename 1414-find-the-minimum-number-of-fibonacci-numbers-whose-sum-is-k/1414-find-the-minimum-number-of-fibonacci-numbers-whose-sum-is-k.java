class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        while (true) {
            int res = list.get(list.size() - 1) + list.get(list.size() - 2);
            if (res > k)
                break;
            list.add(res);
        }
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int res = list.get(i);
            if (res <= k) {
                k -= res;
                count++;
            }
            if (k == 0)
                break;
        }
        return count;
    }
}