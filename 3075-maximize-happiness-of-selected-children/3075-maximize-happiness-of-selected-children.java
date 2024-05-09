class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : happiness)
            list.add(i);
        Collections.sort(list, (a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            if (list.get(i) - i > 0)
                sum += list.get(i) - i;
        }
        return sum;
    }
}