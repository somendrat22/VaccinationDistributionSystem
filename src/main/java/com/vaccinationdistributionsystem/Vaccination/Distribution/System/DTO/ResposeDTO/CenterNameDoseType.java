package com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.ResposeDTO;

public class CenterNameDoseType {

    String centerName;

    String doseType;

    int doseCount;

    public CenterNameDoseType(String centerName, String doseType, int doseCount) {
        this.centerName = centerName;
        this.doseType = doseType;
        this.doseCount = doseCount;
    }

    public CenterNameDoseType() {
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getDoseType() {
        return doseType;
    }

    public void setDoseType(String doseType) {
        this.doseType = doseType;
    }

    public int getDoseCount() {
        return doseCount;
    }

    public void setDoseCount(int doseCount) {
        this.doseCount = doseCount;
    }
}
