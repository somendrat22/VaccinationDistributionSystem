package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddDoctorDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.VaccinationCenterVsDoctorCount;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotPresentException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterService vaccinationCenterService;



    public Doctor createDoctor(AddDoctorDTO dtoObj){
        List<Object []> data = doctorRepository.getVaccinationCenterVsDoctorCount();

        if(data.size() == 0){
            throw new VaccinationCenterNotPresentException("Vaccination center does not exist due to whcih we can't add doctor");
        }



        Object [] minVcId = data.get(0);

        int minID = Integer.parseInt(minVcId[0].toString());

        Doctor obj = new Doctor();

        obj.setDocName(dtoObj.getName());
        obj.setDocDegree(dtoObj.getDegree());
        obj.setVaccinationCenter(vaccinationCenterService.getByID(minID));

        doctorRepository.save(obj);

        return obj;
    }
}
