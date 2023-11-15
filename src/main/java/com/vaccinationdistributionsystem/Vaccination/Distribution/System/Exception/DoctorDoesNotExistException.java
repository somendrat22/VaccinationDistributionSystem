package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception;

public class DoctorDoesNotExistException extends RuntimeException{

    public  DoctorDoesNotExistException(String mssg){
        super(mssg);
    }
}
