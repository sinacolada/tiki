package com.sinacolada.tiki.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_profiles")
public class Profile {

    @Id
    @Column(name = "id")
    public Long id;

    @OneToOne
    @MapsId
    private User user;

    @Column(name = "first_name", length = 60)
    private String firstName;

    @Column(name = "last_name", length = 60)
    private String lastName;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "dob")
    private Date dob;

}