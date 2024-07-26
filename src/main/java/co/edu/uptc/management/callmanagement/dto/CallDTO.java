package co.edu.uptc.management.callmanagement.dto;

import co.edu.uptc.management.callmanagement.enums.ECallType;

public class CallDTO {
    Integer phoneNumber;
    Integer phoneDestiny;
    String callId;
    ECallType callType;
    Double minuteValue;
    Double callDuration;

    public  CallDTO(){

    }
    public CallDTO(Integer phoneNumber, Integer phoneDestiny, String callId, ECallType callType, Double minuteValue, Double callDuration) {
        this.phoneNumber = phoneNumber;
        this.phoneDestiny = phoneDestiny;
        this.callId = callId;
        this.callType = callType;
        this.minuteValue = minuteValue;
        this.callDuration = callDuration;
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

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public ECallType getCallType() {
        return callType;
    }

    public void setCallType(ECallType callType) {
        this.callType = callType;
    }

    public Double getMinuteValue() {
        return minuteValue;
    }

    public void setMinuteValue(Double minuteValue) {
        this.minuteValue = minuteValue;
    }

    public Double getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Double callDuration) {
        this.callDuration = callDuration;
    }


}
