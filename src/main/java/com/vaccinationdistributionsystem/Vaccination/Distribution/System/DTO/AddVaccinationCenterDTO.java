package com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Enums.CentrePrefrence;

public class AddVaccinationCenterDTO {

    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getCovaxinDoses() {
        return covaxinDoses;
    }

    public void setCovaxinDoses(int covaxinDoses) {
        this.covaxinDoses = covaxinDoses;
    }

    public int getCovishieldDose() {
        return covishieldDose;
    }

    public void setCovishieldDose(int covishieldDose) {
        this.covishieldDose = covishieldDose;
    }

    public int getSputnikDose() {
        return sputnikDose;
    }

    public void setSputnikDose(int sputnikDose) {
        this.sputnikDose = sputnikDose;
    }

    public CentrePrefrence getType() {
        return type;
    }

    public void setType(CentrePrefrence type) {
        this.type = type;
    }

    public AddVaccinationCenterDTO() {
    }

    String centerName;

    public AddVaccinationCenterDTO(String address, String centerName, int covaxinDoses, int covishieldDose, int sputnikDose, CentrePrefrence type) {
        this.address = address;
        this.centerName = centerName;
        this.covaxinDoses = covaxinDoses;
        this.covishieldDose = covishieldDose;
        this.sputnikDose = sputnikDose;
        this.type = type;
    }

    int covaxinDoses;
    
    int covishieldDose;

    int sputnikDose;

    CentrePrefrence type;



}
