class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j])
                j--;
            else if (nums1[i] > nums2[j])
                i--;
            else {
                list.add(nums1[i]);
                i--;
                j--;
            }
        }
        int[] arr = new int[list.size()];
        for (int k = 0; k < arr.length; k++)
            arr[k] = list.get(k);
        return arr;
    }
}
