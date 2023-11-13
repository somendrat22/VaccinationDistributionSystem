package com.vaccinationdistributionsystem.Vaccination.Distribution.System.DTO;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddDoctorDTO {

    String name;
    String degree;


}
