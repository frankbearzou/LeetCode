class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Set<Integer> set = new HashSet<>();
        for (int i : arr2) {
            set.add(i);
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        Collections.sort(list);
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int count = map.get(arr2[i]);
            while (count-- > 0) {
                res[index++] = arr2[i];
            }
        }
        int i = 0;
        while (index < arr1.length) {
            res[index++] = list.get(i++);
        }
        return res;
    }
}