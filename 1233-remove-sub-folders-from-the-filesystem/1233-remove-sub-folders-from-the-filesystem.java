class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> ans = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (String s : folder) {
            set.add(s);
        }
        for (String s : folder) {
            List<String> list = get(s);
            for (String str : list) {
                if (set.contains(str)) {
                    ans.add(str);
                    break;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    List<String> get(String str) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '/') {
                ans.add(str.substring(0, i));
            }
        }
        ans.add(str);
        return ans;
    }
}