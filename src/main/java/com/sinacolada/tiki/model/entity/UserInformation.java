package com.sinacolada.tiki.model.entity;

import java.sql.Date;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UserInformation {

    private String firstName;

    private String lastName;

    private String phone;

    private Date dob;

    private String address;

    private String address2;

    private String city;

    private String zipCode;

    private String country;

}