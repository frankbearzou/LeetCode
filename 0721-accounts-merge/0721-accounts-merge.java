class Solution {
    private Map<String, String> parentMap = new HashMap<>();
    private Map<String, String> ownerMap = new HashMap<>();
    private Map<String, TreeSet<String>> unionMap = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        // setup parent map, parent is itself
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parentMap.put(account.get(i), account.get(i));
                ownerMap.put(account.get(i), account.get(0));
            }
        }
        // first email become parent of each group
        for (List<String> account : accounts) {
            String parent = findParent(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                parentMap.put(findParent(account.get(i)), parent);
            }
        }
        // union
        for (List<String> account : accounts) {
            String parent = findParent(account.get(1));
            unionMap.putIfAbsent(parent, new TreeSet<String>());
            for (int i = 1; i < account.size(); i++) {
                unionMap.get(parent).add(account.get(i));
            }
        }
        for (String parent : unionMap.keySet()) {
            List<String> list = new ArrayList<>(unionMap.get(parent));
            list.add(0, ownerMap.get(parent));
            ans.add(list);
        }
        return ans;
    }

    private String findParent(String email) {
        if (parentMap.get(email).equals(email)) {
            return email;
        } else {
            return findParent(parentMap.get(email));
        }
    }
}