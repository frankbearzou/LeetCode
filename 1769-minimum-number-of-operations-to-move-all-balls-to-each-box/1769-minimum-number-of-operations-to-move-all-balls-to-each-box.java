class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        List<Integer> list = new ArrayList<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1')
                list.add(i);
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int index : list) {
                if (index != i) {
                    sum += Math.abs(i - index);
                }
            }
            res[i] = sum;
        }
        return res;
    }
}