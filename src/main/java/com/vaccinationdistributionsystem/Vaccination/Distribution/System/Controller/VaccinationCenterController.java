package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;


import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddVaccinationCenterDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.ResposeDTO.CenterNameDoseType;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/api/vaccinationcenter/add")
    public String createVaccinationCenter(@RequestBody AddVaccinationCenterDTO obj){
        vaccinationCenterService.createVaccinationCenter(obj);
        return "Hey Vaccination Center got created into database successfully";
    }

    @GetMapping("/api/vaccinationcenter")
    public List<VaccinationCenter> searchByName(@RequestParam String centerName){
        return vaccinationCenterService.searchByName(centerName);
    }

    @GetMapping("/api/vaccinationcenter/{centerName}")
    public List<CenterNameDoseType> getParticularVaccinationCenterDoseCount(@PathVariable String centerName, @RequestParam String doseType){
        return vaccinationCenterService.getParticularVaccinationCenterDoseCount(centerName, doseType);
    }
}
