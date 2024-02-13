package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto;

import com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.entity.Gender;

import java.time.LocalDate;

public record DirectorResponse(Long id, String directorName, Gender gender, LocalDate birthDate) {
}
