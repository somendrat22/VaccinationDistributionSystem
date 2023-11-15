package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception;

public class PatientNotPresentInDatabase extends RuntimeException {

    public PatientNotPresentInDatabase(String mssg){
        super(mssg);
    }

}
