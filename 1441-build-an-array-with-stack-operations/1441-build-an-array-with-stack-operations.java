class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int count = 1;
        for (int num : target) {
            while (count != num) {
                res.add("Push");
                res.add("Pop");
                count++;
            }
            if (count == num) {
                res.add("Push");
                count++;
            }
        }
        return res;
    }
}