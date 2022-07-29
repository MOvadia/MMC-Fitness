package com.proj.restapi.auth.info;

import java.util.Objects;

public class SubscriberInformation {

    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private String psw;
    private String type;

    public SubscriberInformation() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPsw() {
        return psw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubscriberInformation)) return false;
        SubscriberInformation that = (SubscriberInformation) o;
        return firstname.equals(that.firstname) && lastname.equals(that.lastname) && phonenumber.equals(that.phonenumber)
                && email.equals(that.email) && psw.equals(that.psw) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, phonenumber, email, psw, type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
