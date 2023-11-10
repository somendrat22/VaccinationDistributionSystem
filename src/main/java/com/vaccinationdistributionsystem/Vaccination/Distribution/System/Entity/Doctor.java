package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int docId;

    String docName;

    String docDegree;

    @ManyToOne
    VaccinationCenter vaccinationCenter;



    @OneToMany(mappedBy = "doctor")
    List<Patient> patients;
    int patientsCount;

    public Doctor() {
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocDegree() {
        return docDegree;
    }

    public void setDocDegree(String docDegree) {
        this.docDegree = docDegree;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public int getPatientsCount() {
        return patientsCount;
    }

    public void setPatientsCount(int patientsCount) {
        this.patientsCount = patientsCount;
    }

    public Doctor(int docId, String docName, String docDegree, VaccinationCenter vaccinationCenter, int patientsCount) {
        this.docId = docId;
        this.docName = docName;
        this.docDegree = docDegree;
        this.vaccinationCenter = vaccinationCenter;
        this.patientsCount = patientsCount;
    }
}
