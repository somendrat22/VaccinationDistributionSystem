package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vcId;

    String centerName;

    int covaxinDose;
    int covishieldDose;
    int sputnikDose;

    String type;

    @OneToMany(mappedBy = "vaccinationCenter")
    List<Doctor> doctors;

    @OneToMany(mappedBy = "vaccinationCenter")
    List<Patient> patients;

    String address;

    public VaccinationCenter() {
    }

    public int getVcId() {
        return vcId;
    }

    public void setVcId(int vcId) {
        this.vcId = vcId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public int getCovaxinDose() {
        return covaxinDose;
    }

    public void setCovaxinDose(int covaxinDose) {
        this.covaxinDose = covaxinDose;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public VaccinationCenter(int vcId, String centerName, int covaxinDose, int covishieldDose, int sputnikDose, String type, String address) {
        this.vcId = vcId;
        this.centerName = centerName;
        this.covaxinDose = covaxinDose;
        this.covishieldDose = covishieldDose;
        this.sputnikDose = sputnikDose;
        this.type = type;
        this.address = address;
    }

    public VaccinationCenter(int vcId) {
        this.vcId = vcId;
    }
}
