package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;


import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddDoctorDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotPresentException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/api/doctor/add")
    public ResponseEntity addDocToDatabse(@RequestBody AddDoctorDTO docDTO){
        try{
            Doctor obj  = doctorService.createDoctor(docDTO);
            return new ResponseEntity(obj, HttpStatus.CREATED);
        }catch(VaccinationCenterNotPresentException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
