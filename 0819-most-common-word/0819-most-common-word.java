class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String[] split = paragraph.toLowerCase().split("[ !?',;.]");
        for (String str : split) {
            if (str.isEmpty())
                continue;
            boolean b = false;
            for (String ban : banned) {
                if (str.equals(ban))
                    b = true;
            }
            if (!b)
                map.put(str, map.getOrDefault(str, 0) + 1);
        }
        String res = "";
        int max = 0;
        for (var entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}