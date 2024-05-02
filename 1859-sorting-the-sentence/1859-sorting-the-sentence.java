class Solution {
    public String sortSentence(String s) {
        String[] split = s.split(" ");
        String[] arr = new String[split.length];
        for (String str : split) {
            int i = str.charAt(str.length() - 1) - '1';
            arr[i] = str.substring(0, str.length() - 1);
        }
        StringBuilder res = new StringBuilder();
        for (String str : arr) {
            res.append(str).append(" ");
        }
        return res.toString().trim();
    }
}