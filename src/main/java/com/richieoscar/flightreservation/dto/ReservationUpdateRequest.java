package com.richieoscar.flightreservation.dto;

public class ReservationUpdateRequest {
    private Long id;
    private int numberOfBags;
    private boolean checkedIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    @Override
    public String toString() {
        return "ReservationUpdateRequest{" +
                "id=" + id +
                ", numberOfBags=" + numberOfBags +
                ", checkedIn=" + checkedIn +
                '}';
    }
}
