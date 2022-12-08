class TwoSum {

    Map<Integer, Integer> hm;

    public TwoSum() {
        hm = new HashMap<>();
    }
    
    public void add(int number) {
        hm.put(number, hm.getOrDefault(number, 0)+1);
    }
    
    public boolean find(int value) {
        for(int key: hm.keySet()) {
            int t=value-key;
            if(t==key) {
                if(hm.get(t)>1) return true;
            } else if(hm.containsKey(t)) 
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */