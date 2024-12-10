class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        s1 = new String(arr1);
        s2 = new String(arr2);
        if (s1.compareTo(s2) > 0) {
            String t = s1;
            s1 = s2;
            s2 = t;
        }
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) > s2.charAt(i))
                return false;
        }
        return true;
    }
}