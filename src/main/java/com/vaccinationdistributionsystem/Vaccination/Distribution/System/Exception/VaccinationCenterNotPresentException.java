package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception;

public class VaccinationCenterNotPresentException extends RuntimeException{

    public VaccinationCenterNotPresentException(String mssg){
        super(mssg);
    }
}
