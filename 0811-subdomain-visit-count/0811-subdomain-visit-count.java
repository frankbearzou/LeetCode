class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            while (domain.indexOf(".") != -1) {
                domain = domain.substring(domain.indexOf(".") + 1);System.out.println(domain);
                map.put(domain, map.getOrDefault(domain, 0) + count);
            }
        }
        for (var entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}