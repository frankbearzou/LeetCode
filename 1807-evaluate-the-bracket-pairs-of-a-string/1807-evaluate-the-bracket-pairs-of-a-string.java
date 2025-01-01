class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder str = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        char[] arr = s.toCharArray();
        int index = 0;
        int n = arr.length;
        while (index < n) {
            if (arr[index] == '(') {
                StringBuilder key = new StringBuilder();
                index++;
                while (index < n && arr[index] != ')') {
                    key.append(arr[index]);
                    index++;
                }
                str.append(map.getOrDefault(key.toString(), "?"));
                index++;
            } else {
                str.append(arr[index]);
                index++;
            }
        }
        return str.toString();
    }
}