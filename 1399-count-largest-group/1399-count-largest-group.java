class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            map.putIfAbsent(sum, new ArrayList());
            map.get(sum).add(i);
        }
        int max = 0;
        for (var val : map.values()) {
            max = Math.max(max, val.size());
        }
        int count = 0;
        for (var val : map.values()) {
            if (val.size() == max)
                count++;
        }
        return count;
    }

    int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}