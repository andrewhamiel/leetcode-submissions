class SeatManager {
    private TreeSet<Integer> availableSeats = new TreeSet<>();
    private int currSeat = 1;

    public SeatManager(int n) {
        
    }
    
    public int reserve() {
        if(!availableSeats.isEmpty()) return availableSeats.removeFirst();

        int reservedSeat = currSeat;
        currSeat++;
        return reservedSeat;
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