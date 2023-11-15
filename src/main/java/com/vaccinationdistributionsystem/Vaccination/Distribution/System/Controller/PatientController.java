package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddPatientDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Patient;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.AlreadyGotVaccinatedException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.DoctorDoesNotExistException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.PatientNotPresentInDatabase;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotPresentException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/api/patient/add")
    public ResponseEntity savePatient(@RequestBody AddPatientDTO patientDTO){
        try{
            Patient obj = patientService.createPatient(patientDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        }catch(DoctorDoesNotExistException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (VaccinationCenterNotPresentException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/api/patient/{pid}")
    public ResponseEntity getPatientByID(@PathVariable int pid){
        try{
            return new ResponseEntity(patientService.getPatientByID(pid), HttpStatus.OK);
        }catch (PatientNotPresentInDatabase p){
            return new ResponseEntity(p.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/api/patient/givedose")
    public ResponseEntity giveDose(@RequestParam int pId){
        try{
            patientService.provideDoseToPatient(pId);
            return new ResponseEntity("Hey Patient got certified and mail is sent to him", HttpStatus.OK);
        }catch(AlreadyGotVaccinatedException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }catch (PatientNotPresentInDatabase e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}
