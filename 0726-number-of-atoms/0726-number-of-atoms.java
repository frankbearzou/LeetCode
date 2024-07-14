class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0, n = formula.length();
        while (i < n) {
            char c = formula.charAt(i);
            i++;
            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
            } else if (c == ')') {
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }
                if (val == 0)
                    val = 1;
                Map<String, Integer> temp = map;
                map = stack.pop();
                for (String key : temp.keySet()) {
                    map.put(key, temp.get(key) * val + map.getOrDefault(key, 0));
                }
            } else {
                int start = i - 1;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String key = formula.substring(start, i);
                int val = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }
                if (val == 0)
                    val = 1;
                map.put(key, map.getOrDefault(key, 0) + val);
            }
        }
        StringBuilder res = new StringBuilder();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (String key : list) {
            res.append(key);
            if (map.get(key) > 1)
                res.append(map.get(key));
        }
        return res.toString();
    }
}