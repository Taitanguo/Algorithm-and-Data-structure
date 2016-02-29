class MedianFinder {
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        minheap.offer(num);
        maxheap.offer(minheap.poll());
        if(maxheap.size() - minheap.size() == 1 ){
            minheap.offer(maxheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (minheap.size() > maxheap.size()? (double)minheap.peek() : (maxheap.peek() + minheap.peek()) / 2.0);
    }};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();