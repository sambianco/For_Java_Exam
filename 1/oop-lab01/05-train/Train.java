public class Train {

    int ntotSeats;
    int nFirstClassSeats;
    int nSecondClassSeats;
    int bookedFirstClassSeats;
    int bookedSecondClassSeats;

    void build(int nFirstClassSeats, int nSecondClassSeats) {
        this.nFirstClassSeats = nFirstClassSeats;
        this.nSecondClassSeats = nSecondClassSeats;
        this.ntotSeats = nFirstClassSeats + nSecondClassSeats;
        this.bookedFirstClassSeats = 0;
        this.bookedSecondClassSeats = 0;
    }

    void bookFirstClassSeats(int nSeats) {
        this.bookedFirstClassSeats += nSeats;
    }

    void bookSecondClassSeats(int nSeats) {
        this.bookedSecondClassSeats += nSeats;
    }

    double getTotalOccupancyRatio() {
        return (double) (this.bookedFirstClassSeats + this.bookedSecondClassSeats) / this.ntotSeats;
    }

    double getFirstClassOccupancyRatio() {
        return (double) this.bookedFirstClassSeats / this.nFirstClassSeats;
    }

    double getSecondClassOccupancyRatio() {
        return (double) this.bookedSecondClassSeats / this.nSecondClassSeats;
    }

    void cancelAllBookings() {
        this.bookedFirstClassSeats = 0;
        this.bookedSecondClassSeats = 0;
    }
}
