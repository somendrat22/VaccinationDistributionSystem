package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddVaccinationCenterDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.ResposeDTO.CenterNameDoseType;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public void createVaccinationCenter(AddVaccinationCenterDTO vaccinationCenterDetails){
        VaccinationCenter obj = new VaccinationCenter();
        obj.setCenterName(vaccinationCenterDetails.getCenterName());
        obj.setCovaxinDose(vaccinationCenterDetails.getCovaxinDoses());
        obj.setCovishieldDose(vaccinationCenterDetails.getCovishieldDose());
        obj.setType(vaccinationCenterDetails.getType().toString());
        obj.setSputnikDose(vaccinationCenterDetails.getSputnikDose());
        obj.setAddress(vaccinationCenterDetails.getAddress());
        vaccinationCenterRepository.save(obj);
    }


    public List<VaccinationCenter> searchByName(String centerName){
        return vaccinationCenterRepository.findByCenterName(centerName);
    }

    public VaccinationCenter getByID(int vcid){
        return  vaccinationCenterRepository.findById(vcid).orElse(null);
    }

    public List<CenterNameDoseType> getParticularVaccinationCenterDoseCount(String vaccinationCenterName, String doseType){
        List<VaccinationCenter> allVaccinationCenterByName = vaccinationCenterRepository.findByCenterName(vaccinationCenterName);

        List<CenterNameDoseType> allVaccinationCenterParticularVaccineDetail = new ArrayList<>();

        for(VaccinationCenter obj : allVaccinationCenterByName){
            CenterNameDoseType dtoObj = new CenterNameDoseType();

            dtoObj.setCenterName(obj.getCenterName());
            dtoObj.setDoseType(doseType);
            if(doseType.equals("SPUTNIK")){
                dtoObj.setDoseCount(obj.getSputnikDose());
            }else if(doseType.equals("COVAXIN")){
                dtoObj.setDoseCount(obj.getCovaxinDose());
            }else if(doseType.equals("COVISHIELD")){
                dtoObj.setDoseCount(obj.getCovishieldDose());
            }

            allVaccinationCenterParticularVaccineDetail.add(dtoObj);
        }

        return allVaccinationCenterParticularVaccineDetail;


    }
}
