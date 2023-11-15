package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Certificates;
import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificates, Integer> {

    @Query(value = "Select * from certificates where patient_pid =:pID", nativeQuery = true)
    public Certificates findByPatientID(int pID);

}
