class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        for (int[] res : restaurants) {
            if (res[3] <= maxPrice && res[4] <= maxDistance) {
                if (veganFriendly == 1 && res[2] == 1 || veganFriendly == 0) {
                    list.add(new int[]{res[0], res[1]});
                }
            }
        }
        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1])
                return b[1] - a[1];
            else
                return b[0] - a[0];
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(i)[0]);
        }
        return ans;
    }
}