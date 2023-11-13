package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Controller;


import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddDoctorDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/api/doctor/add")
    public String addDocToDatabse(@RequestBody AddDoctorDTO docDTO){
        doctorService.createDoctor(docDTO);
        return "Doctor created sucessfully";
    }

}
