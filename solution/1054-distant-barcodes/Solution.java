class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] ans = new int[barcodes.length];
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0, max = 0;
        
        Arrays.sort(barcodes);
        for (int i = 0; i < barcodes.length; i++) {
            int n = map.getOrDefault(barcodes[i], 0) + 1;
            if (n > max) {
                max = n;
                num = barcodes[i];
            }
            map.put(barcodes[i], n);
        }
        
        int idx = 0;
        while (max > 0) {
            ans[idx] = num;
            idx += 2;
            max--;
        }
        
        for (int i = 0; i < barcodes.length; i++) {
            if (idx >= ans.length) {
                idx = 1;
            }
            if (barcodes[i] == num)
                continue;
            ans[idx] = barcodes[i];
            idx += 2;
        }
        
        return ans;
    }
}
