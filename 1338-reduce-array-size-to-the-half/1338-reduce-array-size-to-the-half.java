class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b - a);
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += list.get(i);
            if (sum >= n / 2)
                return i + 1;
        }
        return 1;
    }
}