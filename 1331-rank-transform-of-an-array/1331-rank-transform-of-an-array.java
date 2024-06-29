class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i : list) {
            map.put(i, count);
            count++;
        }
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}