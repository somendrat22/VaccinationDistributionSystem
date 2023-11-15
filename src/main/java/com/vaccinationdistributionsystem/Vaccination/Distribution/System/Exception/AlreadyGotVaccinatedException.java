package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception;

public class AlreadyGotVaccinatedException extends RuntimeException{

    public AlreadyGotVaccinatedException(String mssg){
        super(mssg);
    }
}
