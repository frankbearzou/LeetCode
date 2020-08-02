class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String name = split[1];
            while (name != null && !name.isEmpty()) {
                map.put(name, map.getOrDefault(name, 0) + count);
                if (name.indexOf(".") == -1)
                    break;
                name = name.substring(name.indexOf(".") + 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        
        return ans;
    }
}
