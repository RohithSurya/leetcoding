class MedianFinder {
    
    PriorityQueue<Integer> fhalf, lhalf;

    public MedianFinder() {
        fhalf=new PriorityQueue<>((a,b)->b-a);
        lhalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        fhalf.add(num);
        lhalf.add(fhalf.poll());
        if(fhalf.size()<lhalf.size()) {
            fhalf.add(lhalf.poll());
        }
    }
    
    public double findMedian() {
        if(fhalf.size()>lhalf.size()) {
            return fhalf.peek();
        } else {
            return (fhalf.peek()+lhalf.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */