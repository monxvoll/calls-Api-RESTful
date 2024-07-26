package co.edu.uptc.management.callmanagement.dto;

public class CallInfo {
    Integer phoneNumber;
    Integer phoneDestiny;
    Double totalCost;

    public CallInfo(Integer phoneNumber, Integer phoneDestiny, Double totalCost) {
        this.phoneNumber = phoneNumber;
        this.phoneDestiny = phoneDestiny;
        this.totalCost = totalCost;
    }

    /**
     * @author monx.voll
     */

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPhoneDestiny() {
        return phoneDestiny;
    }

    public void setPhoneDestiny(Integer phoneDestiny) {
        this.phoneDestiny = phoneDestiny;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
