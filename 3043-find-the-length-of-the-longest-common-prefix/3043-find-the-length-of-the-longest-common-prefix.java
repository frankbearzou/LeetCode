class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max = 0;
        ArrayList[] a1 = new ArrayList[arr1.length];
        ArrayList[] a2 = new ArrayList[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            a1[i] = new ArrayList();
            while (arr1[i] > 0) {
                a1[i].add(0, arr1[i] % 10);
                arr1[i] /= 10;
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            a2[i] = new ArrayList();
            while (arr2[i] > 0) {
                a2[i].add(0, arr2[i] % 10);
                arr2[i] /= 10;
            }
        }
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a2.length; j++) {
                int len = 0;
                for (int k = 0; k < a1[i].size() && k < a2[j].size(); k++) {
                    if (a1[i].get(k) == a2[j].get(k))
                        len++;
                    else
                        break;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}