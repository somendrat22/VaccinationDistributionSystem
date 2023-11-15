package com.vaccinationdistributionsystem.Vaccination.Distribution.System.Repository;

import com.vaccinationdistributionsystem.Vaccination.Distribution.System.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer> {

    public List<VaccinationCenter> findByCenterName(String centerName);

    @Query(value = "select vc.vc_id, count(*) from vaccination_center as vc   Left join patient p on vc.vc_id = p.vaccination_center_vc_id  where vc.type = :type group by vc.vc_id order by count asc",nativeQuery = true)
    public List<Object []> getMinimumPatientVaccinationCenter(String type);
}
