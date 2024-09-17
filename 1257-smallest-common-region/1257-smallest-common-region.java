class Solution {
    Map<String, String> map = new HashMap<>();

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        for (List<String> region : regions) {
            String parent = region.get(0);
            for (int i = 1; i < region.size(); i++) {
                map.put(region.get(i), parent);
            }
        }
        List<String> path1 = getPath(region1);
        List<String> path2 = getPath(region2);
        int i = 0, j = 0;
        String ans = "";
        while (i < path1.size() && j < path2.size() && path1.get(i).equals(path2.get(i))) {
            ans = path1.get(i);
            i++;
            j++;
        }
        return ans;
    }

    List<String> getPath(String region) {
        List<String> path = new ArrayList<>();
        path.add(region);
        while (map.containsKey(region)) {
            path.add(0, map.get(region));
            region = map.get(region);
        }
        return path;
    }
}