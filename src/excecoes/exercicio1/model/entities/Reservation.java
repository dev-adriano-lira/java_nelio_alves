package excecoes.exercicio1.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date ckeckOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date ckeckOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.ckeckOut = ckeckOut;
    }

    public long duration() {
        long diff = ckeckOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation dates for update must be future dates";
        }
        if(!checkOut.after(checkIn)) {
            return "Check-ot must be after check-in date";
        }
        this.checkIn = checkIn;
        this.ckeckOut = checkOut;
        return null;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCkeckOut() {
        return ckeckOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(ckeckOut)
                + ", "
                + duration()
                + " nights";
    }

}
