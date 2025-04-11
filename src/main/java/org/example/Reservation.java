package org.example;

public class Reservation {
    private String numeroReservation;
    private Passager passager;
    private Vol vol;

    public Reservation(Passager passager, Vol vol) {
        this.passager = passager;
        this.vol = vol;
        this.numeroReservation = "R" + Math.random();
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public Vol getVol() {
        return vol;
    }
}
