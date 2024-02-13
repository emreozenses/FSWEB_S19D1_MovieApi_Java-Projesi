package com.workintech.FSWEB_S19D1_MovieApi_Java.Projesi.exceptions;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime errorTime;
}
