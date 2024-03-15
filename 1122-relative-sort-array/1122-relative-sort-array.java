class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr1)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int index = 0;
        for (int num : arr2) {
            int count = map.get(num);
            while (count-- > 0) {
                res[index++] = num;
            }
            map.remove(num);
        }
        for (var entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                res[index++] = key;
            }
        }
        return res;
    }
}