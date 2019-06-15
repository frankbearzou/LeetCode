class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for (String op : ops) {
            if ("+".equals(op)) {
                int cur = list.getLast() + list.get(list.size() - 2);
                sum += cur;
                list.add(cur);
            } else if ("D".equals(op)) {
                int cur = list.getLast() * 2;
                sum += cur;
                list.add(cur);
            } else if ("C".equals(op)) {
                int cur = list.removeLast();
                sum -= cur;
            } else {
                int cur = Integer.parseInt(op);
                sum += cur;
                list.add(cur);
            }
        }

        return sum;
    }
}
