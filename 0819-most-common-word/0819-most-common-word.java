class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String res = "";
        Map<String, Integer> map = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        for (String ban : banned)
            banSet.add(ban);
        String[] split = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        for (String str : split) {
            if (banSet.contains(str))
                continue;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
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