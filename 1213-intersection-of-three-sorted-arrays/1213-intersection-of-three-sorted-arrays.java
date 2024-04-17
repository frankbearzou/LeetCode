class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        for (int i : arr2)
            set2.add(i);
        for (int i : arr3)
            set3.add(i);
        for (int i : arr1) {
            if (set2.contains(i) && set3.contains(i))
                res.add(i);
        }
        return res;
    }
}