package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;


import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddVaccinationCenterDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.ResposeDTO.CenterNameDoseType;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotPresentException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/api/vaccinationcenter/add")
    public ResponseEntity createVaccinationCenter(@RequestBody AddVaccinationCenterDTO obj){
        VaccinationCenter vcObj =  vaccinationCenterService.createVaccinationCenter(obj);
        return new ResponseEntity(vcObj, HttpStatus.CREATED);
    }

    @GetMapping("/api/vaccinationcenter")
    public ResponseEntity searchByName(@RequestParam String centerName){

        try{
            List<VaccinationCenter> data = vaccinationCenterService.searchByName(centerName);
            return new ResponseEntity(data, HttpStatus.OK);
        }catch (VaccinationCenterNotPresentException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/api/vaccinationcenter/{centerName}")
    public ResponseEntity getParticularVaccinationCenterDoseCount(@PathVariable String centerName, @RequestParam String doseType){
        return new ResponseEntity(vaccinationCenterService.getParticularVaccinationCenterDoseCount(centerName, doseType), HttpStatus.OK);
    }
}
