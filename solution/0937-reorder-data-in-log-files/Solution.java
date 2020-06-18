class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];
        PriorityQueue<String> queue = new PriorityQueue<>((String a, String b) -> {
            String aSub = a.substring(a.indexOf(" ") + 1);
            String bSub = b.substring(b.indexOf(" ") + 1);
            if (aSub.compareTo(bSub) != 0) {
                return aSub.compareTo(bSub);
            } else {
                return a.compareTo(b);
            }
        });
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            int idx = log.indexOf(" ");
            char ch = log.charAt(idx + 1);
            if (ch >= 'a' && ch <= 'z') {
                queue.add(log);
            } else {
                list.add(i);
            }
        }
        
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i] = queue.poll();
            i++;
        }
        for (int j = 0; j < list.size(); j++) {
            ans[i + j] = logs[list.get(j)];
        }
        
        return ans;
    }
}
