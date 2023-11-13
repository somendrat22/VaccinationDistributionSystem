package com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class VaccinationCenterVsDoctorCount {
    Integer vaccinationId;
    Integer totalDocCount;
}
