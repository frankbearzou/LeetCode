class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int res = 0;
        int min = arrays.get(0).getFirst();
        int max = arrays.get(0).getLast();
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(res, Math.max(Math.abs(min - arrays.get(i).getLast()), Math.abs(max - arrays.get(i).getFirst())));
            min = Math.min(min, arrays.get(i).getFirst());
            max = Math.max(max, arrays.get(i).getLast());
        }
        return res;
    }
}