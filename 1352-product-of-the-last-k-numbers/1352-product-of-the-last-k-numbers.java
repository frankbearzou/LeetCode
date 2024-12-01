class ProductOfNumbers {
    private List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) {
            list = new ArrayList<>();
        } else if (list.isEmpty())
            list.add(num);
        else
            list.add(num * list.getLast());
    }
    
    public int getProduct(int k) {
        if (list.size() < k)
            return 0;
        if (list.size() == k)
            return list.getLast();
        return list.getLast() / (list.get(list.size() - k - 1));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */