package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalErrorResponse {

    private String message;
    private  Integer status;
    private LocalDateTime globalExceptionTime;

}
