package com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Enums.CentrePrefrence;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Enums.VAccinationPrefrence;

public class AddPatientDTO {
    String name;
    CentrePrefrence centrePrefrence;
    VAccinationPrefrence vaccinationPrefrence;
    int phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CentrePrefrence getCentrePrefrence() {
        return centrePrefrence;
    }

    public void setCentrePrefrence(CentrePrefrence centrePrefrence) {
        this.centrePrefrence = centrePrefrence;
    }

    public VAccinationPrefrence getVaccinationPrefrence() {
        return vaccinationPrefrence;
    }

    public void setVaccinationPrefrence(VAccinationPrefrence vaccinationPrefrence) {
        this.vaccinationPrefrence = vaccinationPrefrence;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String email;

    public AddPatientDTO(String name, CentrePrefrence centrePrefrence, VAccinationPrefrence vaccinationPrefrence, int phoneNumber, String email) {
        this.name = name;
        this.centrePrefrence = centrePrefrence;
        this.vaccinationPrefrence = vaccinationPrefrence;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


}
