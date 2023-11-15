package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Service;


import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.AddPatientDTO;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Certificates;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Patient;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.AlreadyGotVaccinatedException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.DoctorDoesNotExistException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.PatientNotPresentInDatabase;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Exception.VaccinationCenterNotPresentException;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.CertificateRepository;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.DoctorRepository;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.PatientRepository;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CertificateRepository certificateRepository;

    public Patient getPatientByID(int pid){
        Patient p  = patientRepository.findById(pid).orElse(null);

        if(p == null){
            throw new PatientNotPresentInDatabase(String.format("Patient with patient id %d does not exist in patients table", pid));
        }

        return p;
    }

    public Patient createPatient(AddPatientDTO patientDTO){
        Patient p = new Patient();
        p.setCenterPrefrence(patientDTO.getCentrePrefrence().toString());
        p.setEmailAddress(patientDTO.getEmail());
        p.setPhoneNumber(patientDTO.getPhoneNumber());
        p.setName(patientDTO.getName());
        p.setVaccinationPrefrence(patientDTO.getVaccinationPrefrence().toString());
        List<Object [] > doctorVsPatient = doctorRepository.getDoctorVsPatientCount();
        if(doctorVsPatient.size() == 0){
            throw new DoctorDoesNotExistException("Hey you are trying to assign a doctor to patient but there is no doctor in database");
        }
        int minDocID = Integer.parseInt(doctorVsPatient.get(0)[0].toString());
        Doctor dobj =  doctorRepository.findById(minDocID).orElse(null);
        p.setDoctor(dobj);
        List<Object []> vaccinationCenterVsPatient = vaccinationCenterRepository.getMinimumPatientVaccinationCenter(patientDTO.getCentrePrefrence().toString());

        if(vaccinationCenterVsPatient.size() ==0){
            throw new VaccinationCenterNotPresentException("Vaccinaton ceneter not present in database, So we are not able to add patient");
        }
        Object [] arr = vaccinationCenterVsPatient.get(0);
        int minId = Integer.parseInt(arr[0].toString());
        VaccinationCenter vcObj = vaccinationCenterRepository.findById(minId).orElse(null);
        p.setVaccinationCenter(vcObj);
        patientRepository.save(p);

        return p;
    }

    public void provideDoseToPatient(int pId){
        Patient obj = patientRepository.findById(pId).orElse(null);

        if(obj == null){
            throw new PatientNotPresentInDatabase(String.format("Patient with pId %d which you are searching is not in the database", pId));
        }

        String email = obj.getEmailAddress();

        String docName = obj.getDoctor().getDocName();

        Certificates vaccineCertificate = new Certificates();

        vaccineCertificate.setPatient(obj);


        // If patient is already present in the certificates table that means that patient is already vaccinated.
        // Thats why already got vaccination error we are going to throw.
        if(certificateRepository.findByPatientID(obj.getPid()) != null){
            throw new AlreadyGotVaccinatedException(String.format("Patient with %d is already vaccinated", pId));
        }

        certificateRepository.save(vaccineCertificate);


        String text = "Hey " + obj.getName() + " , \n" + "Congrats !! You got vaccinated by doctor " + docName + " And your vaccination certificate id is " + vaccineCertificate.getCid() + ".";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("vaccindedistributionproject@gmail.com");

        simpleMailMessage.setTo(obj.getEmailAddress());

        simpleMailMessage.setSubject("Congrats !! you got vaccinated");

        simpleMailMessage.setText(text);

        try{
            javaMailSender.send(simpleMailMessage);
        }catch(Exception e){
            throw e;
        }




    }
}
