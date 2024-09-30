class Solution {
    public String[] expand(String s) {
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        int index = 0;
        int n = s.length();
        while (index < n) {
            if (s.charAt(index) == '{') {
                for (int i = index + 1; i < n; i++) {
                    if (s.charAt(i) == '}') {
                        String str = s.substring(index + 1, i);
                        index = i + 1;
                        String[] split = str.split(",");
                        List<StringBuilder> newList = new ArrayList<>();
                        for (String sp : split) {
                            for (int j = 0; j < list.size(); j++) {
                                newList.add(new StringBuilder(list.get(j)).append(sp));
                            }
                        }
                        list = newList;
                        break;
                    }
                }
            } else {
                for (int i = 0 ; i < list.size(); i++) {
                    list.get(i).append(s.charAt(index));
                }
                index++;
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i).toString();
        Arrays.sort(ans);
        return ans;
    }
}