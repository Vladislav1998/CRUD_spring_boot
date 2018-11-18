package com.javapointers.model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer organization_id;
    @Column
    private  String name_of_organization;
    @Column
    private  String phone;
    @Column
    private  String e_mail;

    public Organization(){    }

    public Integer getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Integer organization_id) {
        this.organization_id = organization_id;
    }

    public String getName_of_organization() {
        return name_of_organization;
    }

    public void setName_of_organization(String name_of_organization) {
        this.name_of_organization = name_of_organization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getE_mail() {
        return e_mail;
    }

    public Organization(String name_of_organization, String phone, String e_mail) {
        this.name_of_organization = name_of_organization;
        this.phone = phone;
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organization_id=" + organization_id +
                ", name_of_organization='" + name_of_organization + '\'' +
                ", phone='" + phone + '\'' +
                ", e_mail='" + e_mail + '\'' +
                '}';
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }
}

