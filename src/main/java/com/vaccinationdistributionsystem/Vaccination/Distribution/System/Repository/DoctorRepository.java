package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO.VaccinationCenterVsDoctorCount;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    @Query(value = "select vaccination_center_vc_id, count(*)  from public.doctor group by vaccination_center_vc_id", nativeQuery = true)
    public List<Object []> getVaccinationCenterVsDoctorCount();
}
