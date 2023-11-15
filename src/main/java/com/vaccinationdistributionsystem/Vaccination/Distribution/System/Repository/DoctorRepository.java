package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.VaccinationCenterVsDoctorCount;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "select vc.vc_id, count(*) from vaccination_center as vc Left join doctor d on vc.vc_id = d.vaccination_center_vc_id group by vc.vc_id order by count asc", nativeQuery = true)
    public List<Object []> getVaccinationCenterVsDoctorCount();

    @Query(value = "select doc_id, count(*) from doctor as doc Left join Patient p on doc.doc_id = p.doctor_doc_id group by doc.doc_id order by count asc", nativeQuery = true)
    public List<Object []> getDoctorVsPatientCount();
}
