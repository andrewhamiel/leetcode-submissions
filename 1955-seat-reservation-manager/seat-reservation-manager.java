class SeatManager {
    private int marker = 1;
    private TreeSet<Integer> availableSeats = new TreeSet<>();

    public SeatManager(int n) {
        
    }
    
    public int reserve() {
        if(!availableSeats.isEmpty()) return availableSeats.removeFirst();
        //otherwise, marker is first seat
        int seatReserved = marker;
        marker++;
        return seatReserved;
    }
    
    public void unreserve(int seatNumber) {
        availableSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */