package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.dto;

import java.time.LocalDate;

public record JustActorResponse(String firstName, String lastName, LocalDate birthDate) {
}
