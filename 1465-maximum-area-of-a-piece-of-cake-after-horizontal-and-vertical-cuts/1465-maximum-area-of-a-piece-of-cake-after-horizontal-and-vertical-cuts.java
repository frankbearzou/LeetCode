class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int)(1e9 + 7);
        List<Integer> hList = new ArrayList<>();
        List<Integer> vList = new ArrayList<>();
        hList.add(0);
        hList.add(h);
        vList.add(0);
        vList.add(w);
        for (int i : horizontalCuts)
            hList.add(i);
        for (int i : verticalCuts)
            vList.add(i);
        Collections.sort(hList);
        Collections.sort(vList);
        long hmax = 0, vmax = 0;
        for (int i = 1; i < hList.size(); i++) {
            hmax = Math.max(hmax, hList.get(i) - hList.get(i - 1));
        }
        for (int i = 1; i < vList.size(); i++) {
            vmax = Math.max(vmax, vList.get(i) - vList.get(i - 1));
        }
        return (int)((hmax * vmax) % mod);
    }
}