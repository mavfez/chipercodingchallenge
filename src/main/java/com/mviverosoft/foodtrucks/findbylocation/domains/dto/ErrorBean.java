package com.mviverosoft.foodtrucks.findbylocation.domains.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ErrorBean extends BaseBean {

    private static final long serialVersionUID = 11L;
    String errorCode;
    String errorDescription;

    public ErrorBean(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
