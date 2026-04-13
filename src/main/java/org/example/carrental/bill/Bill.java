package org.example.carrental.bill;

public class Bill {
    private int billId;
    private int reservationId;
    private double totalBillAmount;
    private boolean billPaid;

    public Bill(int billId, int reservationId, double totalBillAmount){
        this.billId = billId;
        this.reservationId = reservationId;
        this.totalBillAmount = totalBillAmount;
        this.billPaid = false;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

    public boolean isBillPaid() {
        return billPaid;
    }

    public void setBillPaid(boolean billPaid) {
        this.billPaid = billPaid;
    }
}
