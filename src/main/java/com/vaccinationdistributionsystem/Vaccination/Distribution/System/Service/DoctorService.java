package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddDoctorDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.VaccinationCenterVsDoctorCount;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterService vaccinationCenterService;


    public void createDoctor(AddDoctorDTO dtoObj){
        List<Object []> data = doctorRepository.getVaccinationCenterVsDoctorCount();

        // [{vcid}, {}]
        int minVcid = 1;
        int minDoc =  Integer.MAX_VALUE;

        for(Object [] vcidVsCount : data){
            System.out.println(vcidVsCount[0].toString());
            if(Integer.parseInt(vcidVsCount[1].toString()) < minDoc){
                minDoc = (Integer.parseInt(vcidVsCount[1].toString()));
                minVcid = (Integer.parseInt(vcidVsCount[0].toString()));
            }
        }

        Doctor obj = new Doctor();

        obj.setDocName(dtoObj.getName());
        obj.setDocDegree(dtoObj.getDegree());
        obj.setVaccinationCenter(vaccinationCenterService.getByID(minVcid));

        doctorRepository.save(obj);
    }
}
