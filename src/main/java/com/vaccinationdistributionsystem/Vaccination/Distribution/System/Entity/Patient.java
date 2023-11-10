package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity;


import jakarta.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pid;

    String name;

    String vaccinationPrefrence;

    String centerPrefrence;

    @ManyToOne
    VaccinationCenter vaccinationCenter;

    @ManyToOne
    Doctor doctor;

    @Column(unique = true)
    int phoneNumber;

    @Column(unique = true)
    String emailAddress;

    @OneToOne
    Certificates certificates;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVaccinationPrefrence() {
        return vaccinationPrefrence;
    }

    public void setVaccinationPrefrence(String vaccinationPrefrence) {
        this.vaccinationPrefrence = vaccinationPrefrence;
    }

    public String getCenterPrefrence() {
        return centerPrefrence;
    }

    public void setCenterPrefrence(String centerPrefrence) {
        this.centerPrefrence = centerPrefrence;
    }

    public VaccinationCenter getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Certificates getCertificates() {
        return certificates;
    }

    public void setCertificates(Certificates certificates) {
        this.certificates = certificates;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public Patient(int pid, String name, String vaccinationPrefrence, String centerPrefrence, VaccinationCenter vaccinationCenter, Doctor doctor, int phoneNumber, String emailAddress, Certificates certificates, boolean isVaccinated) {
        this.pid = pid;
        this.name = name;
        this.vaccinationPrefrence = vaccinationPrefrence;
        this.centerPrefrence = centerPrefrence;
        this.vaccinationCenter = vaccinationCenter;
        this.doctor = doctor;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.certificates = certificates;
        this.isVaccinated = isVaccinated;
    }

    public Patient() {
    }

    boolean isVaccinated;

}
