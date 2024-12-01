class Cashier {
    private Map<Integer, Integer> map;
    private int count;
    private int n;
    private int discount;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        map = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            map.put(products[i], prices[i]);
        }
        this.n = n;
        this.discount = discount;
    }
    
    public double getBill(int[] product, int[] amount) {
        count++;
        double sum = 0;
        for (int i = 0; i < product.length; i++) {
            sum += map.get(product[i]) * amount[i];
        }
        if (count % n == 0)
            sum = sum * ((100 - discount) / 100.0);
        return sum;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */