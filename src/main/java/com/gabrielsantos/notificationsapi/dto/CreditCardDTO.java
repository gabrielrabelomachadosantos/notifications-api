package com.gabrielsantos.notificationsapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CreditCardDTO {

    private String number;

    @JsonFormat(pattern = "yyyy/MM")
    private Date expiringDate;

}
