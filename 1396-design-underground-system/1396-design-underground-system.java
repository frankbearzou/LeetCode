class UndergroundSystem {
    Map<Integer, Info> in;
    Map<Integer, Info> out;
    Map<String, List<Integer>> timeMap;

    public UndergroundSystem() {
        in = new HashMap<>();
        out = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        in.put(id, new Info(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Info info = in.get(id);
        String address = info.stationName + "_" + stationName;
        int time = t - info.t;
        timeMap.computeIfAbsent(address, k -> new ArrayList<>()).add(time);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String address = startStation + "_" + endStation;
        List<Integer> list = timeMap.get(address);
        double sum = 0;
        for (int t : list) {
            sum += t;
        }
        return sum / list.size();
    }
}

class Info {
    String stationName;
    int t;
    Info(String stationName, int t) {
        this.stationName = stationName;
        this.t = t;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */