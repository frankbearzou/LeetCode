class OrderedStream {
    private String[] arr;
    private int n;
    private int index;

    public OrderedStream(int n) {
        arr = new String[n + 1];
        this.n = n;
        index = 1;
    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> list = new ArrayList<>();
        while (index <= n) {
            if (arr[index] != null) {
                list.add(arr[index]);
                index++;
            } else
                break;
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */