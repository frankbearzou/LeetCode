class BrowserHistory {
    private String current;
    private Stack<String> prev;
    private Stack<String> next;

    public BrowserHistory(String homepage) {
        current = homepage;
        prev = new Stack<>();
        next = new Stack<>();
    }
    
    public void visit(String url) {
        prev.push(current);
        current = url;
        next.clear();
    }
    
    public String back(int steps) {
        while (steps > 0 && !prev.isEmpty()) {
            next.push(current);
            current = prev.pop();
            steps--;
        }
        return current;
    }
    
    public String forward(int steps) {
        while (steps > 0 && !next.isEmpty()) {
            prev.push(current);
            current = next.pop();
            steps--;
        }
        return current;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */