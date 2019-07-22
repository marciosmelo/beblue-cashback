package com.beblue.cashback.model.error;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ErrorResponse {
    private LocalDate timestamp;
    private String message;
    private String details;

    public ErrorResponse() {
    }

    public ErrorResponse(String error) {
        this.message = error;
    }

    public ErrorResponse(LocalDate timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }


}
